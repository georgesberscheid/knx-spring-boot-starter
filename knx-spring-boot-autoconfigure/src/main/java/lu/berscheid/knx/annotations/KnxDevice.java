package lu.berscheid.knx.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier("KnxDevice")
public @interface KnxDevice {

	// Defines the individual address of the device. Can be overwritten during programming.
	// Defaults to 0.0.1
	String individualAddress() default "${knx.individualAddress:0.0.1}";

	// Defines the manufacturer reference for this device.
	// Defaults to 00FA (KNX association)
	String manufacturerRefId() default "${knx.manufacturerRefId:M-00FA}";

	String applicationName() default "";

	int applicationNumber() default 1;

	int applicationVersion() default 0;

	String hardwareName() default "";

	String hardwareSerialNumber() default "1";

	int hardwareVersionNumber() default 1;

	String productName() default "";

	String productOrderNumber() default "1";

	// The default name of the parameter block shown in ETS
	String defaultParameterBlockText() default "Parameters";
}
