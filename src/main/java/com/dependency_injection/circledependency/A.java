package com.dependency_injection.circledependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    public String value = "a";
    @Autowired
    private B b;

//    @Autowired
    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

//    @Autowired
//    public A(B b) {
//        this.b = b;
//    }
}
