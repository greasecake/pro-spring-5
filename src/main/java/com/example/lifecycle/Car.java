package com.example.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car implements InitializingBean {
    private final Engine engine;
    private int maxSpeed;

    @Value("0.1")
    private float distance;

    @Autowired
    public Car(Engine engine) {
        System.out.println("Constructing Car and injecting Engine");
        this.engine = engine;
    }

    @Autowired
    public void setMaxSpeed(
            @Value("100") int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void afterPropertiesSet() {
        System.out.println("Initializing Engine after properties");
    }
//
//    private void init() {
//        System.out.println("Initializing Engine with init-method");
//        engine.startEngine();
//    }

    @PostConstruct
    public void startCar() {
        System.out.println("Initializing Engine Post Construction");
        engine.startEngine();
    }

    @PreDestroy
    public void stopCar() {
        System.out.println("Destroying Engine");
        engine.stopEngine();
    }

    public void run() throws InterruptedException {
        int eta = (int) (distance/maxSpeed*3600);
        System.out.printf("\tRunning at %dkm/h, ETA: %ds%n", maxSpeed, eta);
        Thread.sleep(eta * 1000L);
        System.out.println("\tReached destination");
    }
}
