package com.ronitCodes.demoAOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // This is where we add all of our advices

    // Let's Start with and @Before advice
            // PointCUT expression
    @Before("execution(* com.ronitCodes.demoAOP.DAO.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n  =====>>> In the beforeAddAccountAdvice() method");
    }

}
