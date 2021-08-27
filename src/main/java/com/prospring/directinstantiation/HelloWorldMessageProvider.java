package com.prospring.directinstantiation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloWorldMessageProvider implements MessageProvider {
    private final String message;

    public HelloWorldMessageProvider() {
        int random = (int) (Math.random() * 10000);
        message = "Hello World " + random;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
