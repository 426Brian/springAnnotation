package com.sprAnnotation.conf;

import com.sprAnnotation.bean.Color;
import com.sprAnnotation.bean.Person;
import com.sprAnnotation.condition.LinuxCondition;
import com.sprAnnotation.condition.WindowsCondition;
import com.sprAnnotation.imports.MyImportSelector;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Created by Brian in 7:03 2018/12/12
 */

@Configuration
@ComponentScan(value = {"com.sprAnnotation"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
@Import({Color.class, MyImportSelector.class})
public class MainConfig {
    @Bean
    public Person person(){
        return new Person("Jack", 19);
    }

    // @Conditional 还可以用在类上对类中所有组件判断
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person1(){
        return new Person("Bill Gate", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person2(){
        return new Person("linus", 62);
    }

}
