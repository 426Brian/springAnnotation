package com.sprAnnotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    private Car car;


    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss --> constructor");
    }

    public Car getCar() {
        return car;
    }


    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
