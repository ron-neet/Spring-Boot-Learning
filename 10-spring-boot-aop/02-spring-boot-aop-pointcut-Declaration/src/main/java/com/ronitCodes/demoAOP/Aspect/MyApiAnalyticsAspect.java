package com.ronitCodes.demoAOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

    @Before("com.ronitCodes.demoAOP.Aspect.AopExpression.forDaoPackage()")
    public void performApiAnalyticsAdvice(){

        System.out.println("\n =======> in the performApiAnalyticsAdvice() method");
    }

}
