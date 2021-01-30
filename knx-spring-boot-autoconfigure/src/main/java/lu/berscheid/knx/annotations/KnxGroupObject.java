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
public @interface KnxGroupObject {

	String text() default "";

	String functionText() default "";
	
	String datapointType() default "";

	int sizeInBits() default 8;

	long minInclusive() default 0;

	long maxInclusive() default 255;

	Flag[] flags() default { Flag.C };

	String[] groupAddresses() default {};

	String updateValueCallback() default "";

	String readValueCallback() default "";

	public enum Flag {
		C, // Communication
		R, // Read - object reacts to GroupValueRead and sends GroupValueResponse
		W, // Write - object reacts to GroupValueWrite
		T, // Transmit - object sends GroupValueWrite
		U // Update - object sends GroupValueRead reacts to GroupValueResponse
	}
}
