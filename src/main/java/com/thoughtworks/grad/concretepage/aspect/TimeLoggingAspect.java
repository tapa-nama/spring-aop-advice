package com.thoughtworks.grad.concretepage.aspect;

import com.thoughtworks.grad.concretepage.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class TimeLoggingAspect {
    @Before("execution(* com.thoughtworks.grad.concretepage.service.*.add(..))")
    public void logBefore() {
        Logger.log("@Before");
    }

    @After("execution(* com.thoughtworks.grad.concretepage.service.*.subtract(..))")
    public void logAfter() {
        Logger.log("@After");
    }

    @Around("execution(* com.thoughtworks.grad.concretepage.service.*.multiply(..))")
    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger.log("@Around: Before calculation-");
        joinPoint.proceed();
        Logger.log("@Around: After calculation-");
    }

    @AfterReturning(pointcut = "execution(* com.thoughtworks.grad.concretepage.service.*.divide(..))", returning = "obj")
    public void logAfterReturning(Object obj) {
        Logger.log("Method return value: " + obj);
        Logger.log("@AfterReturning:");
    }

    @AfterThrowing(pointcut = "execution(* com.thoughtworks.grad.concretepage.service.*.divide(..))", throwing = "e")
    public void logAfterThrowing(Exception e) {
        System.out.println("@AfterReturning:" + new Date());
        System.out.println("Exception caught:" + e.getMessage());
    }
}
