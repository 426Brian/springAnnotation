package com.sprAnnotation.conf;

import com.sprAnnotation.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtConfig {

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
