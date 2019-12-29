package com.sprAnnotation.bean;

import org.springframework.context.annotation.Import;

/**
 * Created by Brian in 8:28 2018/12/12
 */
public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
