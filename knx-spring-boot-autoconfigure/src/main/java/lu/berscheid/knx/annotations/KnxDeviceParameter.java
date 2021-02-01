package lu.berscheid.knx.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface KnxDeviceParameter {
	String text() default "";

	int sizeInBit() default 0;

	double minInclusive() default -1;

	double maxInclusive() default -1;
}
