package com.thoughtworks.grad.concretepage.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class TimeLoggingAspect {
    @Before("execution(* com.thoughtworks.grad.concretepage.service.*.*(..))")
    public void logBefore() {
        System.out.println("@Before:" + new Date());
    }

    @After("execution(* com.thoughtworks.grad.concretepage.service.*.*(..))")
    public void logAfter() {
        System.out.println("@After:" + new Date());
    }
}
