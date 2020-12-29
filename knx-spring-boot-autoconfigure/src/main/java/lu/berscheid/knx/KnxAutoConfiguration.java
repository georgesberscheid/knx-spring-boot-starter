package lu.berscheid.knx;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
import lu.berscheid.knx.annotations.KnxPostStart;
import lu.berscheid.knx.annotations.KnxRequestDatapointMethod;
import lu.berscheid.knx.annotations.KnxUpdateDatapointMethod;
import lu.berscheid.knx.commandline.KnxCommandlineParser;
import lu.berscheid.knx.commandline.KnxRunnable;
import lu.berscheid.knx.model.GroupObject;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxGroupObjectConfig;
import lu.berscheid.knx.model.KnxGroupObjectConfig.Priority;
import lu.berscheid.knx.model.KnxParameterConfig;
import lu.berscheid.knx.model.KnxParameterTypeConfig;

@Slf4j
@Configuration
@ConditionalOnClass(KnxLink.class)
public class KnxAutoConfiguration implements CommandLineRunner, BeanPostProcessor, BeanFactoryAware {

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

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
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
		config.setApplicationName(annotation.applicationName().equals("") ? className : annotation.applicationName());
		config.setApplicationNumber(annotation.applicationNumber());
		config.setApplicationVersion(annotation.applicationVersion());
		config.setHardwareName(annotation.hardwareName().equals("") ? className : annotation.hardwareName());
		config.setHardwareSerialNumber(annotation.hardwareSerialNumber());
		config.setHardwareVersionNumber(annotation.hardwareVersionNumber());
		config.setProductName(annotation.productName().equals("") ? className : annotation.productName());
		config.setProductOrderNumber(annotation.productOrderNumber());

		// Look for fields annotated with @KnxDeviceParameter
		ReflectionUtils.doWithFields(bean.getClass(), field -> processParameters(bean, field, config),
				field -> matchFieldWithAnnotation(field, KnxDeviceParameter.class));

		// Look for fields annotated with @KnxGroupObject
		ReflectionUtils.doWithFields(bean.getClass(), field -> processGroupObjects(bean, field, config),
				field -> matchFieldWithAnnotation(field, KnxGroupObject.class));

		// Look for update and request datapoint methods
		ReflectionUtils.doWithMethods(bean.getClass(), method -> processUpdateDatapointMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxUpdateDatapointMethod.class));
		ReflectionUtils.doWithMethods(bean.getClass(), method -> processRequestDatapointMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxRequestDatapointMethod.class));

		// Look for a KNX post start method
		ReflectionUtils.doWithMethods(bean.getClass(), method -> processPostStartMethod(bean, method, config),
				method -> matchMethodWithAnnotation(method, KnxPostStart.class));

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
		try {
			// Try and get the default value
			field.setAccessible(true);
			Object value = field.get(device);
			if (value != null) {
				config.setValue(value.toString());
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			log.warn("Unable to get default value from device " + device.getClass() + " for field " + field.getName()
					+ ": " + e.getMessage());
		}

		KnxParameterTypeConfig typeConfig = new KnxParameterTypeConfig();
		typeConfig.setType(field.getType());

		// Check for supported parameter types
		long minInclusive = annotation.minInclusive();
		long maxInclusive = annotation.maxInclusive();
		if (field.getType() == int.class) {
			typeConfig.setMinInclusive(minInclusive == -1 ? Integer.MIN_VALUE : minInclusive);
			typeConfig.setMaxInclusive(maxInclusive == -1 ? Integer.MAX_VALUE : maxInclusive);
			typeConfig.setSizeInBit(32);
		} else if (field.getType() == long.class) {
			typeConfig.setMinInclusive(minInclusive == -1 ? Long.MIN_VALUE : minInclusive);
			typeConfig.setMaxInclusive(maxInclusive == -1 ? Long.MAX_VALUE : maxInclusive);
			typeConfig.setSizeInBit(64);
		} else if (field.getType() == String.class) {
			typeConfig.setSizeInBit(50 * 8);
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

		Class<?> type = field.getType();
		if (!type.equals(GroupObject.class)) {
			log.error("@KnxGroupObject declared on field " + field.getName() + " with type " + field.getType()
					+ ". You must use GroupObject<>. Group Object is being ignored.");
			return;
		}

		Type genericType = field.getGenericType();
		if (genericType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) genericType;
			Type[] typeArguments = parameterizedType.getActualTypeArguments();
			if (typeArguments.length != 1) {
				log.error("@KnxGroupObject type must be parameterized with exactly 1 parameter. @KnxGroupObject definition "
						+ field.getName() + " has: " + typeArguments + ". Group Object is being ignored.");
				return;
			}
			if (typeArguments[0] instanceof Class<?>) {
				config.setType((Class<?>) typeArguments[0]);
			} else {
				log.error("Parameter of GroupObject " + field.getName() + " is not a raw type: " + typeArguments[0]);
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
		config.setCommunicationFlag(annotation.communication());
		config.setReadFlag(annotation.read());
		config.setTransmitFlag(annotation.transmit());
		config.setUpdateFlag(annotation.update());
		config.setWriteFlag(annotation.write());
		config.setName(field.getName());
		config.setText(annotation.text());
		config.setFunctionText(annotation.text());
		config.setSizeInBits(annotation.sizeInBits());
		config.setPriority(Priority.LOW);
		deviceConfig.addGroupObject(config);
	}

	private void processUpdateDatapointMethod(Object device, Method method, KnxDeviceConfig deviceConfig) {
		KnxUpdateDatapointMethod annotation = method.getAnnotation(KnxUpdateDatapointMethod.class);
		String groupObjectName = annotation.groupObjectName();
		KnxGroupObjectConfig groupObjectConfig = deviceConfig.getGroupObject(groupObjectName);

		// Check if we have a group object that matches this updateDatapoint method
		if (groupObjectConfig == null) {
			log.error("Unable to find a group object named " + groupObjectName + " on device "
					+ deviceConfig.getApplicationName() + ". Skipping update datapoint method " + method.getName());
			return;
		}

		// Check if the method has a single parameter whose type matches the group object
		if (method.getParameterCount() != 1 || !method.getParameters()[0].getType().equals(groupObjectConfig.getType())) {
			log.error("Update datapoint method for group object " + groupObjectName
					+ " must have exactly one parameter of type " + groupObjectConfig.getType());
			return;
		}

		log.debug("Found update datapoint method: " + method.getName() + " for group object " + groupObjectName);
		groupObjectConfig.setUpdateDatapointMethod(method);
	}

	private void processRequestDatapointMethod(Object device, Method method, KnxDeviceConfig deviceConfig) {
		KnxRequestDatapointMethod annotation = method.getAnnotation(KnxRequestDatapointMethod.class);
		String groupObjectName = annotation.groupObjectName();
		KnxGroupObjectConfig groupObjectConfig = deviceConfig.getGroupObject(groupObjectName);

		// Check if we have a group object that matches this updateDatapoint method
		if (groupObjectConfig == null) {
			log.error("Unable to find a group object named " + groupObjectName + " on device "
					+ deviceConfig.getApplicationName() + ". Skipping request datapoint method " + method.getName());
			return;
		}

		// Check if the method has a single parameter whose type matches the group object
		if (method.getParameterCount() > 0 || !method.getReturnType().equals(groupObjectConfig.getType())) {
			log.error("Request datapoint method for group object " + groupObjectName
					+ " must not have any parameters and return an object of type " + groupObjectConfig.getType());
			return;
		}

		log.debug("Found request datapoint method: " + method.getName() + " for group object " + groupObjectName);
		groupObjectConfig.setRequestDatapointMethod(method);
	}

	private void processPostStartMethod(Object device, Method method, KnxDeviceConfig deviceConfig) {
		log.debug("Found post start method: " + method.getName());

		// Check if we have already retrieved an init method for this device
		if (deviceConfig.getPostStartMethod() != null) {
			log.error("Device " + deviceConfig.getApplicationName() + " has already an post start method defined: "
					+ deviceConfig.getPostStartMethod().getName()
					+ ". Only one post start method can be defined. Post start method " + method.getName()
					+ " is being ignored.");
			return;
		}

		// Make sure the post start method doesn't have any parameters defined
		if (method.getParameterCount() > 0) {
			log.error("Post start method " + method.getName() + " has " + method.getParameterCount() + " parameters: "
					+ method.getParameters() + ". Post start method cannot have parameters. Post start method "
					+ method.getName() + " is being ignored.");
			return;
		}

		deviceConfig.setPostStartMethod(method);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ConfigurableBeanFactory) beanFactory;
	}
}