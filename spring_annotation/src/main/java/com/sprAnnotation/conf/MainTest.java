package com.sprAnnotation.conf;

import com.sprAnnotation.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Brian in 7:07 2018/12/12
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean(Person.class);

        System.out.println(person.toString());

        String[] beanNames = context.getBeanNamesForType(Person.class);
        for (String bean : beanNames) {
            System.out.println(bean);
        }
    }
}
