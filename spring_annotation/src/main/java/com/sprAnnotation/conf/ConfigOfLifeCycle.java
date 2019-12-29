package com.sprAnnotation.conf;

import com.sprAnnotation.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean 的生命周期
 *      bean 的创建 --> 初始化 --> 销毁的过程
 *  容器管理 bean 的生命周期
 *  我们可以自定义初始化和销毁方法, 容器在bean 进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 */
@Configuration
@ComponentScan("com.sprAnnotation.bean")
public class ConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
