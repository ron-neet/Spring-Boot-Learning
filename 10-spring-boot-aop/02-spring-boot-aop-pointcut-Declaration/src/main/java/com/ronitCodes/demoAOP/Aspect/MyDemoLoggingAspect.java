package com.ronitCodes.demoAOP.Aspect;

import com.ronitCodes.demoAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    // This is where we add all of our advices

    // Let's Start with and @Before advice
//            // PointCUT expression   they are in separate Class the pointcut expression
//    @Pointcut("execution(* com.ronitCodes.demoAOP.DAO.*.*(..))")
//    private void forDaoPackage(){}
//
//    // pointcut expression for getter
//    @Pointcut("execution(* com.ronitCodes.demoAOP.*.get*(..))")
//    private void forGetter(){}
//
//    // pointcut expression for setter
//    @Pointcut("execution(* com.ronitCodes.demoAOP.*.set*())")
//    private void forSetter(){ }
//
//    // pointcut expression for both
//    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
//    private void forDaoPackageNoGetterSetter(){}

    @Before("com.ronitCodes.demoAOP.Aspect.AopExpression.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("\n  =====>>> In the beforeAddAccountAdvice() method");

        // Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature : "+ methodSignature);

        // Display the arguments
        // Get Args
        Object[] args = joinPoint.getArgs();

        // Loop Thru args
        for(Object tempArg : args){
            System.out.println("The Arguments : " + tempArg );


            if(tempArg instanceof Account){

                // Downcast and print Account

                Account theAccount = (Account) tempArg;
                System.out.println("Account Name : " + theAccount.getAccountName());
                System.out.println("Account Number : " + theAccount.getAccountNumber());
            }
        }

    }

}
