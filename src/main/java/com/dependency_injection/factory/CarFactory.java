package com.dependency_injection.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class CarFactory implements FactoryBean<Car>, InitializingBean {
    private String carName = "sedan";
    private Car car = null;

    @Override
    public Car getObject() throws Exception {
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        car = Car.getInstance()
    }
}
