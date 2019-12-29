package com.sprAnnotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspect {

    @Pointcut("execution(* com.sprAnnotation.aop.MathCalculator.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Before --> "+name+"("+Arrays.toString(args)+")");
    }

    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("After --> "+name+"("+Arrays.toString(args)+")");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void returning(JoinPoint joinPoint, Object result){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("AfterReturning --> "+name+"("+Arrays.toString(args)+")"+" returning "+result);
    }

    @AfterThrowing(value = "pointCut()", throwing="exception")
    public void throwing(JoinPoint joinPoint, Exception exception){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("AfterThrowing --> "+name+"("+Arrays.toString(args)+")"+" exception "+exception);
    }

}
