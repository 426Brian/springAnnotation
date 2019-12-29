package com.sprAnnotation.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(String name){
        return "hello from com.sprAnnotation.mvc.service.HelloService "+name;
    }
}
