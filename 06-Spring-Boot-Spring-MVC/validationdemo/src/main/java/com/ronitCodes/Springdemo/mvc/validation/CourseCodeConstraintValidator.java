package com.ronitCodes.Springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;


    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override              // Form Data Entered     // You can replace error message with your custom message
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        // You can add your custom logic to validate
        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }else{
            result = true;
        }

        return result;

    }
}
