package com.sprAnnotation.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是 Windows 操作系统
 * Created by Brian in 7:59 2018/12/12
 */
public class WindowsCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {


        // 1. 获取当前环境
        Environment environment = context.getEnvironment();
        String os = environment.getProperty("os.name");
        if(os.contains("Windows")){
            return true;
        }


       /* // 2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        // 3. 能获取到 IOC 使用的 beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();


        // 4. 获取bean 定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
           可以给容器中注册组件
        */

        return false;

    }
}
