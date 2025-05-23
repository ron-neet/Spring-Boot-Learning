package com.ronitCodes.demoAOP.Aspect;

import com.ronitCodes.demoAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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


    @Around("execution(* com.ronitCodes.demoAOP.Service.TrafficFortuneServiceImpl.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out the method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n ====>>>> Executing @Around on method : " + method);

        // get begin timestamp
        long beginTimestamp = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        try {
            proceedingJoinPoint.proceed();
        }catch (Exception exc){

            // Log the Exception
            System.out.println("\n ====>>>> Exception : " + exc.getMessage());

            // Rethrow the Exception

            throw exc;



//            // giver user a custom message
//            result = "Crassssshhhhhhhhhhh!! but do not worry your private AOp is on the way to fix it";
        }
        // get the end timestamp
        long endTimestamp = System.currentTimeMillis();

        // compute duration and display it
        long duration = endTimestamp - beginTimestamp;
        System.out.println("\n ====>>>> The duration of the method is : " + duration / 1000.0  + " ms");

        return result;
    }


    @After("execution(* com.ronitCodes.demoAOP.DAO.AccountDAO.findAccount(..))")
    public void afterFinallyFindAccountAdvice(){
        System.out.println("\n =======>>>>>> In the afterFinallyFindAccountAdvice() method");
    }

    @AfterThrowing( pointcut = "execution(* com.ronitCodes.demoAOP.DAO.AccountDAO.findAccount(..))",
    throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinpoint, Throwable theExc){

        // Print out which method we are advising on
        System.out.println("\n =======>>>>>> " +
                "In the @afterThrowingFindAccountsAdvice() method for the method : ");

        // log the exception
        System.out.println("\n =======>>>>>> The exception is : " + theExc);
    }


    // Add a new Advice for @AfterReturning on the findAccount method
    @AfterReturning(
            pointcut = "execution(* com.ronitCodes.demoAOP.DAO.AccountDAO.findAccount(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinpoint, List<Account> result){

        // Print out which method we are advising
        String method = joinpoint.getSignature().toShortString();
        System.out.println("\n =======>>>>>> " +
                "In the afterReturningFindAccountsAdvice() method for the method : " + method);

        // Print out the result of the method call
        System.out.println("\n =======>>>>>> The result is : " + result);

        // Let's post-process the data

        // Convert the account name to upper case
        convertAccountIntoUpperCase(result);

        System.out.println("\n =======>>>>>> The result is : " + result);

    }

    private void convertAccountIntoUpperCase(List<Account> result) {

        // loop through account
        for (Account tempAccount : result) {

            // get UppperCase
            String upperName = tempAccount.getAccountName().toUpperCase();

            // update the name of student
            tempAccount.setAccountName(upperName);
        }
    }

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
