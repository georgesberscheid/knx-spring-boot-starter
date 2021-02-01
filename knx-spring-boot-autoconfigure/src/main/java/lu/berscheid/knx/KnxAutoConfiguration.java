package lu.berscheid.knx;

import static lu.berscheid.knx.utils.KnxTypeUtils.isBoolean;
import static lu.berscheid.knx.utils.KnxTypeUtils.isDouble;
import static lu.berscheid.knx.utils.KnxTypeUtils.isEnum;
import static lu.berscheid.knx.utils.KnxTypeUtils.isFloat;
import static lu.berscheid.knx.utils.KnxTypeUtils.isInteger;
import static lu.berscheid.knx.utils.KnxTypeUtils.isLong;
import static lu.berscheid.knx.utils.KnxTypeUtils.isString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

import com.github.rvesse.airline.Cli;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.annotations.KnxDevice;
import lu.berscheid.knx.annotations.KnxDeviceParameter;
import lu.berscheid.knx.annotations.KnxGroupObject;
import lu.berscheid.knx.annotations.KnxGroupObject.Flag;
import lu.berscheid.knx.annotations.KnxPostRestart;
import lu.berscheid.knx.annotations.KnxPostStart;
import lu.berscheid.knx.annotations.KnxPreShutdown;
import lu.berscheid.knx.annotations.KnxRequestDatapoint;
import lu.berscheid.knx.annotations.KnxUpdateDatapoint;
import lu.berscheid.knx.commandline.KnxCommandlineParser;
import lu.berscheid.knx.commandline.KnxRunnable;
import lu.berscheid.knx.model.GroupObject;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxGroupObjectConfig;
import lu.berscheid.knx.model.KnxGroupObjectConfig.Priority;
import lu.berscheid.knx.model.KnxParameterConfig;
import lu.berscheid.knx.model.KnxParameterTypeConfig;
import lu.berscheid.knx.utils.KnxTypeUtils;

@Slf4j
@Configuration
@ConditionalOnClass(KnxLink.class)
public class KnxAutoConfiguration
		implements CommandLineRunner, BeanPostProcessor, BeanFactoryAware {

	private List<KnxDeviceConfig> knxDeviceConfigs = new ArrayList<KnxDeviceConfig>();
	private ConfigurableBeanFactory beanFactory;

	@Override
	public void run(String... args) throws Exception {
		Cli<Runnable> cli = new Cli<Runnable>(KnxCommandlineParser.class);
		Runnable cmd = cli.parse(args);
		if (cmd instanceof KnxRunnable) {
			((KnxRunnable) cmd).run(knxDeviceConfigs);
		} else {
			cmd.run();
		}
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (!bean.getClass().isAnnotationPresent(KnxDevice.class)) {
			return bean;
		}

		log.debug("Found KNX device definition " + bean.getClass());

		// Create a KNX device config and populate from the annotated class
		KnxDevice annotation = bean.getClass().getAnnotation(KnxDevice.class);
		KnxDeviceConfig config = new KnxDeviceConfig();
		// Removes the $$EnhancerBySpringCGLIB part of the class simple name
		String className = bean.getClass().getSimpleName();
		if (className.indexOf("$$") != -1) {
			className = className.substring(0, className.indexOf("$$"));
		}
		config.setDeviceInstance(bean);
		config.setIndividualAddress(beanFactory.resolveEmbeddedValue(annotation.individualAddress()));
		config.setManufacturerRefId(beanFactory.resolveEmbeddedValue(annotation.manufacturerRefId()));
		// Validate manufacturer ID
		if (config.getManufacturerRefId() == null || !config.getManufacturerRefId().startsWith("M-")
				|| !(config.getManufacturerRefId().length() == 6)) {
			log.error("Invalid manufacturer ID : " + config.getManufacturerRefId()
					+ ". Needs to start with 'M-' followed by 2 bytes integer hex representation (e.g. M-00FA).");
			return bean;
		}
		try {
			Integer.parseInt(config.getManufacturerRefId().substring(2), 16);
		} catch (Exception e) {
			log.error("Invalid manufacturer ID : " + config.getManufacturerRefId()
					+ ". Needs to start with 'M-' followed by 2 bytes integer hex representation (e.g. M-00FA).");
			return bean;
		}
		config.setApplicationName(
				annotation.applicationName().equals("") ? className : annotation.applicationName());
		config.setApplicationNumber(annotation.applicationNumber());
		config.setApplicationVersion(annotation.applicationVersion());
		config.setHardwareName(
				annotation.hardwareName().equals("") ? className : annotation.hardwareName());
		// Generating a the .knxprod file will fail if there are special chars
		String hardwareSerialNumber = annotation.hardwareSerialNumber() == null ? null
				: annotation.hardwareSerialNumber().replaceAll("[^a-zA-Z0-9]", "");
		config.setHardwareSerialNumber(hardwareSerialNumber);
		config.setHardwareVersionNumber(annotation.hardwareVersionNumber());
		config.setProductName(
				annotation.productName().equals("") ? className : annotation.productName());
		config.setProductOrderNumber(annotation.productOrderNumber());

		// Look for fields annotated with @KnxDeviceParameter
		ReflectionUtils.doWithFields(bean.getClass(), field -> processParameters(bean, field, config),
				field -> matchFieldWithAnnotation(field, KnxDeviceParameter.class));

		// Look for fields annotated with @KnxGroupObject
		ReflectionUtils.doWithFields(bean.getClass(),
				field -> processGroupObjects(bean, field, config),
				field -> matchFieldWithAnnotation(field, KnxGroupObject.class));

		// Look for update and request datapoint methods
		ReflectionUtils.doWithMethods(bean.getClass(),
				method -> processUpdateDatapointMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxUpdateDatapoint.class));
		ReflectionUtils.doWithMethods(bean.getClass(),
				method -> processRequestDatapointMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxRequestDatapoint.class));

		// Look for a KNX post start method
		ReflectionUtils.doWithMethods(bean.getClass(),
				method -> processPostStartMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxPostStart.class));

		// Look for a KNX post restart method
		ReflectionUtils.doWithMethods(bean.getClass(),
				method -> processPostRestartMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxPostRestart.class));

		// Look for a KNX pre shutdown method
		ReflectionUtils.doWithMethods(bean.getClass(),
				method -> processPreShutdownMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxPreShutdown.class));

		log.trace("Device config: " + config.toString());
		knxDeviceConfigs.add(config);

		return bean;
	}

	private boolean matchFieldWithAnnotation(Field field, Class<? extends Annotation> clazz) {
		return field.getAnnotation(clazz) != null;
	}

	private boolean matchMethodWithAnnotation(Method method, Class<? extends Annotation> clazz) {
		return method.getAnnotation(clazz) != null;
	}

	private void processParameters(Object device, Field field, KnxDeviceConfig deviceConfig) {
		log.debug("Found KNX Parameter: " + field.getName());
		KnxDeviceParameter annotation = field.getAnnotation(KnxDeviceParameter.class);
		KnxParameterConfig config = new KnxParameterConfig();
		config.setName(field.getName());
		config.setText(annotation.text().equals("") ? field.getName() : annotation.text());
		config.setField(field);
		try {
			// Try and get the default value
			field.setAccessible(true);
			Object value = field.get(device);
			if (value != null) {
				config.setValue(value);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			log.warn("Unable to get default value from device " + device.getClass() + " for field "
					+ field.getName() + ": " + e.getMessage());
		}

		KnxParameterTypeConfig typeConfig = new KnxParameterTypeConfig();
		typeConfig.setType(field.getType());

		// Check for supported parameter types
		double minInclusive = annotation.minInclusive();
		double maxInclusive = annotation.maxInclusive();
		if (isBoolean(typeConfig.getType())) {
			typeConfig.setMinInclusive(0);
			typeConfig.setMaxInclusive(1);
			typeConfig.setSizeInBit(8);
		} else if (isInteger(typeConfig.getType())) {
			typeConfig.setMinInclusive(minInclusive == -1 ? Integer.MIN_VALUE : minInclusive);
			typeConfig.setMaxInclusive(maxInclusive == -1 ? Integer.MAX_VALUE : maxInclusive);
			typeConfig.setSizeInBit(32);
		} else if (isLong(typeConfig.getType())) {
			typeConfig.setMinInclusive(minInclusive == -1 ? Long.MIN_VALUE : minInclusive);
			typeConfig.setMaxInclusive(maxInclusive == -1 ? Long.MAX_VALUE : maxInclusive);
			typeConfig.setSizeInBit(64);
		} else if (isFloat(typeConfig.getType())) {
			typeConfig.setMinInclusive(Float.MIN_VALUE);
			typeConfig.setMaxInclusive(Float.MAX_VALUE);
			typeConfig.setSizeInBit(32);
		} else if (isDouble(typeConfig.getType())) {
			log.warn(
					"KNX doesn't support 64bit floating point types (double). Reducing to 32bit (float).");
			typeConfig.setMinInclusive(Float.MIN_VALUE);
			typeConfig.setMaxInclusive(Float.MAX_VALUE);
			typeConfig.setSizeInBit(32);
		} else if (isString(typeConfig.getType())) {
			// If the size wasn't defined, use a default value of 50 bytes
			typeConfig.setSizeInBit(annotation.sizeInBit() == 0 ? 50 * 8 : annotation.sizeInBit());
		} else if (isEnum(typeConfig.getType())) {
			typeConfig.setSizeInBit(8);
		} else {
			throw new RuntimeException("Parameter type " + field.getType() + " is not supported.");
		}
		config.setTypeConfig(typeConfig);

		deviceConfig.addParameter(config);
	}

	private void processGroupObjects(Object device, Field field, KnxDeviceConfig deviceConfig) {
		log.debug("Found KNX Group Object: " + field.getName());
		KnxGroupObject annotation = field.getAnnotation(KnxGroupObject.class);
		KnxGroupObjectConfig config = new KnxGroupObjectConfig();

		// Check that the type of the annotated field is GroupObject<>
		Class<?> type = field.getType();
		if (!type.equals(GroupObject.class)) {
			log.error("@KnxGroupObject declared on field " + field.getName() + " with type "
					+ field.getType() + ". You must use GroupObject<>. Group Object is being ignored.");
			return;
		}

		// Check the type of the parameterized field
		Type genericType = field.getGenericType();
		if (genericType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) genericType;
			Type[] typeArguments = parameterizedType.getActualTypeArguments();
			if (typeArguments.length != 1) {
				log.error(
						"@KnxGroupObject type must be parameterized with exactly 1 parameter. @KnxGroupObject definition "
								+ field.getName() + " has: " + typeArguments
								+ ". Group Object is being ignored.");
				return;
			}
			if (typeArguments[0] instanceof Class<?>) {
				config.setType((Class<?>) typeArguments[0]);
				// Set the datapoint type
				if (StringUtils.isEmpty(annotation.datapointType())) {
					config.setDataPointType(KnxTypeUtils.getDefaultDatapointType(config.getType()));
				} else {
					if (KnxTypeUtils.isValidDatapointTypeForJavaType(annotation.datapointType(),
							config.getType())) {
						config.setDataPointType(annotation.datapointType());
					} else {
						log.error("The provided datapoint type " + annotation.datapointType()
								+ " is invalid for the given defined Java type the group object has "
								+ "been parameterized with: " + config.getType());
						return;
					}
				}
			} else {
				log.error("Parameter of GroupObject " + field.getName() + " is not a raw type: "
						+ typeArguments[0]);
			}
		} else {
			log.error("@KnxGroupObject declared on non-parametrized field " + field.getName()
					+ ". Use GroupObject<Boolean> for example. Group Object is being ignored.");
			return;
		}

		config.setField(field);
		config.setGroupAddresses(new ArrayList<String>());
		for (String groupAddress : annotation.groupAddresses()) {
			config.getGroupAddresses().add(beanFactory.resolveEmbeddedValue(groupAddress));
		}

		Set<Flag> flags = Set.of(annotation.flags());
		config.setCommunicationFlag(flags.contains(Flag.C));
		config.setReadFlag(flags.contains(Flag.R));
		config.setTransmitFlag(flags.contains(Flag.T));
		config.setUpdateFlag(flags.contains(Flag.U));
		config.setWriteFlag(flags.contains(Flag.W));
		config.setName(field.getName());
		config.setText(annotation.text() != null ? annotation.text() : config.getName());
		config.setFunctionText(
				annotation.functionText() != null ? annotation.functionText() : config.getText());
		config.setSizeInBits(annotation.sizeInBits());
		config.setPriority(Priority.LOW);
		deviceConfig.addGroupObject(config);
	}

	private void processUpdateDatapointMethod(Object device, Method method,
			KnxDeviceConfig deviceConfig) {
		KnxUpdateDatapoint annotation = method.getAnnotation(KnxUpdateDatapoint.class);
		String groupObjectName = annotation.groupObjectName();
		KnxGroupObjectConfig groupObjectConfig = deviceConfig.getGroupObject(groupObjectName);

		// Check if we have a group object that matches this updateDatapoint method
		if (groupObjectConfig == null) {
			log.error("Unable to find a group object named " + groupObjectName + " on device "
					+ deviceConfig.getApplicationName() + ". Skipping update datapoint method "
					+ method.getName());
			return;
		}

		// Check if the method has a single parameter whose type matches the group object
		if (method.getParameterCount() != 1
				|| !method.getParameters()[0].getType().equals(groupObjectConfig.getType())) {
			log.error("Update datapoint method for group object " + groupObjectName
					+ " must have exactly one parameter of type " + groupObjectConfig.getType());
			return;
		}

		log.debug("Found update datapoint method: " + method.getName() + " for group object "
				+ groupObjectName);

		// If a group object has an updateDatapointMethod, make sure the W flag is set
		if (!groupObjectConfig.isWriteFlag()) {
			log.info("Group object " + groupObjectConfig.getName()
					+ " has an update datapoint method defined, but the write flag is not "
					+ "enabled. Enabling now.");
			groupObjectConfig.setWriteFlag(true);
		}

		groupObjectConfig.setUpdateDatapointMethod(method);
	}

	private void processRequestDatapointMethod(Object device, Method method,
			KnxDeviceConfig deviceConfig) {
		KnxRequestDatapoint annotation = method.getAnnotation(KnxRequestDatapoint.class);
		String groupObjectName = annotation.groupObjectName();
		KnxGroupObjectConfig groupObjectConfig = deviceConfig.getGroupObject(groupObjectName);

		// Check if we have a group object that matches this updateDatapoint method
		if (groupObjectConfig == null) {
			log.error("Unable to find a group object named " + groupObjectName + " on device "
					+ deviceConfig.getApplicationName() + ". Skipping request datapoint method "
					+ method.getName());
			return;
		}

		// Check if the method has a single parameter whose type matches the group object
		if (method.getParameterCount() > 0
				|| !method.getReturnType().equals(groupObjectConfig.getType())) {
			log.error("Request datapoint method for group object " + groupObjectName
					+ " must not have any parameters and return an object of type "
					+ groupObjectConfig.getType());
			return;
		}

		log.debug("Found request datapoint method: " + method.getName() + " for group object "
				+ groupObjectName);

		// If a group object has a requestDatapointMethod, make sure the R flag is set
		if (!groupObjectConfig.isReadFlag()) {
			log.info("Group object " + groupObjectConfig.getName()
					+ " has an update datapoint method defined, but the read flag is not "
					+ "enabled. Enabling now.");
			groupObjectConfig.setReadFlag(true);
		}

		groupObjectConfig.setRequestDatapointMethod(method);
	}

	private void processPostStartMethod(Object device, Method method, KnxDeviceConfig deviceConfig) {
		log.debug("Found post start method: " + method.getName());

		// Check if we have already retrieved a post start method for this device
		if (deviceConfig.getPostStartMethod() != null) {
			log.error("Device " + deviceConfig.getApplicationName()
					+ " has already a post start method defined: "
					+ deviceConfig.getPostStartMethod().getName()
					+ ". Only one post start method can be defined. Post start method "
					+ method.getName() + " is being ignored.");
			return;
		}

		// Make sure the post start method doesn't have any parameters defined
		if (method.getParameterCount() > 0) {
			log.error("Post start method " + method.getName() + " has " + method.getParameterCount()
					+ " parameters: " + method.getParameters()
					+ ". Post start method cannot have parameters. Post start method " + method.getName()
					+ " is being ignored.");
			return;
		}

		deviceConfig.setPostStartMethod(method);
	}

	private void processPostRestartMethod(Object device, Method method,
			KnxDeviceConfig deviceConfig) {
		log.debug("Found post restart method: " + method.getName());

		// Check if we have already retrieved an init method for this device
		if (deviceConfig.getPostRestartMethod() != null) {
			log.error("Device " + deviceConfig.getApplicationName()
					+ " has already a post restart method defined: "
					+ deviceConfig.getPostRestartMethod().getName()
					+ ". Only one post restart method can be defined. Post restart method "
					+ method.getName() + " is being ignored.");
			return;
		}

		// Make sure the post restart method doesn't have any parameters defined
		if (method.getParameterCount() > 0) {
			log.error("Post restart method " + method.getName() + " has " + method.getParameterCount()
					+ " parameters: " + method.getParameters()
					+ ". Post restart method cannot have parameters. Post restart method "
					+ method.getName() + " is being ignored.");
			return;
		}

		deviceConfig.setPostRestartMethod(method);
	}

	private void processPreShutdownMethod(Object device, Method method,
			KnxDeviceConfig deviceConfig) {
		log.debug("Found pre shutdown method: " + method.getName());

		// Check if we have already retrieved an init method for this device
		if (deviceConfig.getPreShutdownMethod() != null) {
			log.error("Device " + deviceConfig.getApplicationName()
					+ " has already a pre shutdown method defined: "
					+ deviceConfig.getPreShutdownMethod().getName()
					+ ". Only one pre shutdown can be defined. Pre shutdown method " + method.getName()
					+ " is being ignored.");
			return;
		}

		// Make sure the post start method doesn't have any parameters defined
		if (method.getParameterCount() > 0) {
			log.error("Pre shutdown method " + method.getName() + " has " + method.getParameterCount()
					+ " parameters: " + method.getParameters()
					+ ". Pre shutdown method cannot have parameters. Pre shutdown method "
					+ method.getName() + " is being ignored.");
			return;
		}

		deviceConfig.setPreShutdownMethod(method);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ConfigurableBeanFactory) beanFactory;
	}
}