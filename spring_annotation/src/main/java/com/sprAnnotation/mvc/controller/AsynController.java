package com.sprAnnotation.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
@RequestMapping("/asy")
public class AsynController {

    @ResponseBody
    @RequestMapping("/callable")
    public Callable<String> asyn01(){
        System.out.println("com.sprAnnotation.mvc.controller.AsynController --> asyn01() "+Thread.currentThread()+" start -->");
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("com.sprAnnotation.mvc.controller.AsynController --> asyn01() "+Thread.currentThread()+" start -->");
                Thread.sleep(3000);
                System.out.println("com.sprAnnotation.mvc.controller.AsynController --> asyn01() "+Thread.currentThread()+" end -->");
                return "com.sprAnnotation.mvc.controller.AsynController --> asyn01() --> call() ";

            }
        };

        System.out.println("com.sprAnnotation.mvc.controller.AsynController --> asyn01() "+Thread.currentThread()+" end -->");
        return callable;

    }
}
