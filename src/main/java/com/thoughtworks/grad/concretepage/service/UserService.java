package com.thoughtworks.grad.concretepage.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Integer multiply(int a, int b) {
        int result = a * b;
        System.out.println(a + "*" + b + "= " + result);
        return result;
    }
}
