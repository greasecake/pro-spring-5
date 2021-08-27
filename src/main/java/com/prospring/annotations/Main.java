package com.prospring.annotations;

import com.prospring.directinstantiation.MessageProvider;
import com.prospring.directinstantiation.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MessageRenderer renderer1 = (MessageRenderer) ctx.getBean("renderer");
        renderer1.setProvider((MessageProvider) ctx.getBean("provider"));
        renderer1.render();

        MessageRenderer renderer2 = (MessageRenderer) ctx.getBean("renderer");
        renderer2.setProvider((MessageProvider) ctx.getBean("provider"));
        renderer2.render();
    }
}
