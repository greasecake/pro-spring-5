package com.example.circledependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    public String value = "b";
    @Autowired
    private A a;

//    @Autowired
    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

//    @Autowired
//    public B(A a) {
//        this.a = a;
//    }
}
