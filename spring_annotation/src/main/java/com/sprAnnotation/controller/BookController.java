package com.sprAnnotation.controller;

import com.sprAnnotation.dao.BookDao;
import com.sprAnnotation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Brian in 7:16 2018/12/12
 */

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/demo")
    public String demo(){
        return "demo";
    }
}
