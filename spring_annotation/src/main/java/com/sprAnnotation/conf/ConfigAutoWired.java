package com.sprAnnotation.conf;

import com.sprAnnotation.bean.Car;
import com.sprAnnotation.bean.Color;
import com.sprAnnotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(value = {"com.sprAnnotation.controller", "com.sprAnnotation.service", "com.sprAnnotation.bean", "com.sprAnnotation.dao"})
public class ConfigAutoWired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
