package com.ronitCodes.demoAOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {

    // PointCUT expression
    @Pointcut("execution(* com.ronitCodes.demoAOP.DAO.*.*(..))")
    public void forDaoPackage(){}

    // pointcut expression for getter
    @Pointcut("execution(* com.ronitCodes.demoAOP.*.get*(..))")
    public void forGetter(){}

    // pointcut expression for setter
    @Pointcut("execution(* com.ronitCodes.demoAOP.*.set*())")
    public void forSetter(){ }

    // pointcut expression for both
    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    public void forDaoPackageNoGetterSetter(){}

}
