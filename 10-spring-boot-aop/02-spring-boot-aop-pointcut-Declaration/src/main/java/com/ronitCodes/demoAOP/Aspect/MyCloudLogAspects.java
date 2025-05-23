package com.ronitCodes.demoAOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspects {

    @Before("com.ronitCodes.demoAOP.Aspect.AopExpression.forDaoPackage()")
    public void logToCloudAdvice(){

        System.out.println("\n =======> in the logToCloudAdvice() method");
    }
}
