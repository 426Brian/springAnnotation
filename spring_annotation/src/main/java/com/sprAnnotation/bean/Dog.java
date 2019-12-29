package com.sprAnnotation.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog() {
        System.out.println("Dog constructor --> Dog()");
    }

    @PostConstruct
    public void postContruct(){
        System.out.println("Dog postContruct --> postContruct()");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Dog preDestroy --> preDestroy()");
    }
}
