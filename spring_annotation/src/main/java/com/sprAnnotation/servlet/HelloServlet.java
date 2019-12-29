package com.sprAnnotation.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/webhello", asyncSupported = true)
public class HelloServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("com.sprAnnotation.servlet.HelloServlet --> "+Thread.currentThread()+" start --->");
        try {
            sayhello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("hello blocked servlet thread");

        System.out.println("com.sprAnnotation.servlet.HelloServlet --> "+Thread.currentThread()+" end --->");
    }

    public static void sayhello() throws InterruptedException {
        System.out.println("com.sprAnnotation.servlet.HelloServlet --> "+Thread.currentThread()+"== sayhello() processing ==");
        Thread.sleep(3000);

    }
}
