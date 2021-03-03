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
public @interface KnxDeviceParameterBlock {

	/*
	 * The label for this parameter block that will appear in ETS.
	 */
	String text();

	/*
	 * Whether this parameter block should be nested into the parent block. This only applies to the
	 * default parameter block. If nested is false (default value), this block will be rendered at
	 * the same leve as the default parameter block. If nested is true, this block will be rendered
	 * as a sub-block of the default parameter block.
	 */
	boolean nested() default false;
}
