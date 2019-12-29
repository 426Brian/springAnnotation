package com.sprAnnotation.conf;

import com.sprAnnotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value={"classpath:person.Properties"})
public class ConfigPropertyValue {

    @Bean
    public Person person(){

        return new Person();
    }
}
