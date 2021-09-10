package com.dependency_injection.lifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Engine {
    private boolean isRunning;

    public Engine() {
        System.out.println("Constructing Engine");
    }

    public void startEngine() {
        isRunning = true;
        System.out.println("Engine: Vroom!");
    }
    public void stopEngine() {
        isRunning = false;
        System.out.println("Engine: ...");
    }
}
