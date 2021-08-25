package com.prospring.annotations;

import com.prospring.directinstantiation.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MessageRenderer renderer = (MessageRenderer) ctx.getBean("renderer");
        renderer.render();
    }
}
