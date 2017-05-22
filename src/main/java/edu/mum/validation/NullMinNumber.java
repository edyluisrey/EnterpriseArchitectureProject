package edu.mum.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

 
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
 
import javax.validation.constraints.Size;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import org.hibernate.validator.constraints.ConstraintComposition;
 import org.hibernate.validator.constraints.CompositionType;


	@NotNull
	@Min(value = 0)
	@Target( { ElementType.METHOD, ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	@Constraint(validatedBy = {})
	@Documented
	@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
	@ReportAsSingleViolation
	public @interface NullMinNumber {

		String message() default "Number must have minimum value";

		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default {  };

		@OverridesAttribute(constraint = Min.class, name = "value")
		long value();
	}

