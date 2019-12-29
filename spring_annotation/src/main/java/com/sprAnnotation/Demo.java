package com.sprAnnotation;

import com.sprAnnotation.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Brian in 7:00 2018/12/12
 */
public class Demo {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/bean.xml");
        Person person = (Person) context.getBean("person");

        System.out.println(person.toString());

    }
}
