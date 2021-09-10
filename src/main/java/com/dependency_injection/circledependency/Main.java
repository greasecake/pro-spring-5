package com.dependency_injection.circledependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class.getPackage().getName());
        A a = ctx.getBean("a", A.class);
        System.out.println(a.value);
        System.out.println(a.getB().value);
    }
}
