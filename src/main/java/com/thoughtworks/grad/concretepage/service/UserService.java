package com.thoughtworks.grad.concretepage.service;

import com.thoughtworks.grad.concretepage.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Integer multiply(int a, int b) {
        int result = a * b;
        Logger.log(a + " * " + b + " = " + result);
        return result;
    }

    public Integer divide(int a, int b) {
        int result = a / b;
        System.out.println(a + " / " + b + " = " + result);
        return result;
    }
}
