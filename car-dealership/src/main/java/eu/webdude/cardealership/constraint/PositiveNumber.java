package eu.webdude.cardealership.constraint;

import eu.webdude.cardealership.validator.PositiveNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PositiveNumberValidator.class)
public @interface PositiveNumber {

	String message() default "Should be a positive number!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
