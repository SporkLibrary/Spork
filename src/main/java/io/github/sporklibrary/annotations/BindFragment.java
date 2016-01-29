package io.github.sporklibrary.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Bind a Fragment instance.
 * Can be used on a Fragment field in a Fragment/Activity.
 * The bound Fragment field can be a Fragment or any class derived from it.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BindFragment
{
	// TODO: implement support for finding fragments by tag

	/**
	 * The value specified is the Fragment id. When not specified, the name of the field will be used to resolve the id's name.
	 * For example: "@BindFragment Fragment my_fragment;" would bind to R.id.my_fragment
	 * @return Fragment resource id as defined in R.id.*
	 */
	int value() default 0;
}
