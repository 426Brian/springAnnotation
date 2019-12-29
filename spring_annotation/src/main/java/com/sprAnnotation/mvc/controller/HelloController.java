package com.sprAnnotation.mvc.controller;

import com.sprAnnotation.mvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/annotation")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
        public String hello(){
        String tomcat = helloService.sayHello("tomcat");
        return "hello from com.sprAnnotation.mvc.controller.HelloController "+tomcat;
    }

    @RequestMapping("/jsp_test")
    public String test(){
        return "jsp/index";
    }
}
