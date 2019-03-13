package src.theory;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//https://www.youtube.com/watch?v=UlhtkjfxUUU&t=93s
@Target(ElementType.METHOD)
@Documented
@Inherited
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotations {

}

@Target(ElementType.METHOD)
@interface MethodAnnotation {

}

@Target(ElementType.FIELD)
@interface FieldAnnotation {
	String name() default "Sai";

	String[] tags() default { "Sai", "Kanth" };
}

@Target(ElementType.TYPE)
@interface ClassAnnotation {

}

@ClassAnnotation
class Testing {

	@FieldAnnotation
	String name;

	@MethodAnnotation
	public String getName() {
		return this.name;
	};

}
