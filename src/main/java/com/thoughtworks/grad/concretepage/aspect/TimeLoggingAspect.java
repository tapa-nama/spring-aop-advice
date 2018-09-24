package com.thoughtworks.grad.concretepage.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class TimeLoggingAspect {
//    @Before("execution(* com.thoughtworks.grad.concretepage.service.*.*(..))")
//    public void logBefore() {
//        System.out.println("@Before:" + new Date());
//    }

//    @After("execution(* com.thoughtworks.grad.concretepage.service.*.*(..))")
//    public void logAfter() {
//        System.out.println("@After:" + new Date());
//    }

    @Around("execution(* com.thoughtworks.grad.concretepage.service.*.*(..))")
    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around: Before calculation-" + new Date());
        joinPoint.proceed();
        System.out.println("@Around: After calculation-" + new Date());
    }
}
