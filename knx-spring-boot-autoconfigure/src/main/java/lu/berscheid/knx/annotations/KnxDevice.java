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
	String individualAddress() default "1.1.254";

	String manufacturerRefId() default "M-00FA"; // KNX Association

	String applicationName() default "";

	int applicationNumber() default 1;

	int applicationVersion() default 0;

	String hardwareName() default "";

	String hardwareSerialNumber() default "1";

	int hardwareVersionNumber() default 1;

	String productName() default "";

	String productOrderNumber() default "1";
}
