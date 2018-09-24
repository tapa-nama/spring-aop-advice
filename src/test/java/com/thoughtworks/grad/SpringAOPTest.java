package com.thoughtworks.grad;

import com.thoughtworks.grad.concretepage.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAOPTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AspectConfig.class);
        applicationContext.refresh();
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.multiply(2, 3);
        userService.divide(1, 0);
    }
}
