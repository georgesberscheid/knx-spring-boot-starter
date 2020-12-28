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
	String text() default "Group Object";

	int sizeInBits() default 8;

	long minInclusive() default 0;

	long maxInclusive() default 255;

	boolean communication() default true;

	boolean read() default true;

	boolean write() default false;

	boolean transmit() default true;

	boolean update() default false;

	String[] groupAddresses() default {};
}
