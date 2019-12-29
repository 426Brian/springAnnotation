package com.sprAnnotation.mvc.controller;

import com.sprAnnotation.mvc.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@Controller
@RequestMapping("/deferred")
public class DeferredController {


    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult order(){
        DeferredResult<Object> deferredResult = new DeferredResult<Object>(3000L, "create failed ...");

        // 保存起来
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(){

        String order = UUID.randomUUID().toString();
        DeferredResult deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);

        return "create success..."+order;
    }
}
