package com.sprAnnotation.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/webasyn", asyncSupported = true)
public class HelloAsynServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("com.sprAnnotation.servlet.HelloAsynServlet --> "+Thread.currentThread()+" start --->");
        // 通过asyncSupported = true 支持异步, 然后开启异步
        AsyncContext asyncContext = req.startAsync();


        // start 里是 Runnable 用函数式编程, 异步处理sayhello();
        asyncContext.start(()->{
            try {
                System.out.println("com.sprAnnotation.servlet.HelloAsynServlet --> "+Thread.currentThread()+" start --->");
                sayhello();
                // 异步完成
                asyncContext.complete();

                // 写出数据
                asyncContext.getResponse().getWriter().write("hello asynchronise");
                System.out.println("com.sprAnnotation.servlet.HelloAsynServlet --> "+Thread.currentThread()+" end --->");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        System.out.println("com.sprAnnotation.servlet.HelloAsynServlet --> "+Thread.currentThread()+" end --->");
}

    public static void sayhello() throws InterruptedException {
        System.out.println("com.sprAnnotation.servlet.HelloAsynServlet --> "+Thread.currentThread()+"== sayhello() processing ==");
        Thread.sleep(3000);

    }
}
