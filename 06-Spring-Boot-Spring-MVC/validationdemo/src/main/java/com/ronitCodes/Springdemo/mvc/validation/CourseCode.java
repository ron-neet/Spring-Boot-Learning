package com.ronitCodes.Springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // Define Default Course Code
    public String value() default "CRE";

    // Define Default error Message
    public String message() default "Invalid Course Code";

    // Define Default Groups
    public Class<?>[] groups() default {};

    // Define Default Payload
    // It gives more details about the error like which field has the error
    public Class<? extends Payload>[] payload() default {};

}
