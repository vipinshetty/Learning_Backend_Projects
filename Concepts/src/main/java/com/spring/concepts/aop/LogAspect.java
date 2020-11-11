package com.spring.concepts.aop;
/*
* Log Aspect class and here we are using AspectJAnnotation approach to define this class as aspect
*
* */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {
    /*
    * This is called pointcut, basically it is an expression which find a join point
    * */
    @Pointcut("execution(* ApplicationService.*())")
    public void beforePointCutMethod(){ }

    @Pointcut("execution(public ApplicationService.*())")
    public void aroundPointCutMethod(){ }

    /*
    * This is called Advice, specially BeforeAdvice and this block of code will be applied at join point whereever applicable
    * */
    @Before("beforePointCutMethod()")
    public void adviceBefore(JoinPoint jp){
        System.out.println("Inside Before advice");
        // System.out.println("Method Signature: "  + jp.getSignature());
        // explore on API, Provides lot of details
    }

    @AfterReturning(pointcut = "execution(* Operation.*(..))", returning= "result")
    public void myadvice(JoinPoint jp,Object result)//it is advice (after returning advice)
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Result in advice: "+result);
        System.out.println("end of after returning advice...");
    }

    @Around("aroundPointCutMethod()")
    public Object myadvice(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("Additional Concern Before calling actual method");
        Object obj=pjp.proceed();
        System.out.println("Additional Concern After calling actual method");
        return obj;
    }

    @AfterThrowing(
            pointcut = "execution(* Operation.*(..))",
            throwing= "error")

    public void myadvice(JoinPoint jp,Throwable error)//it is advice
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception is: "+error);
        System.out.println("end of after throwing advice...");
    }
}
