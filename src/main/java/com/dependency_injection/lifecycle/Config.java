package com.dependency_injection.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class Config {
    @Lazy
    @Bean
    public Engine getEngine() {
        return new Engine();
    }

    @Lazy
    @Bean(initMethod = "init")
    public Car getCar() {
        return new Car(getEngine());
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan(Config.class.getPackage().getName());
        ctx.refresh();

        Car car = ctx.getBean("car", Car.class);
        car.run();
        ctx.registerShutdownHook();
//        ctx.close();
//        ctx.getDefaultListableBeanFactory().destroySingletons();
    }
}
