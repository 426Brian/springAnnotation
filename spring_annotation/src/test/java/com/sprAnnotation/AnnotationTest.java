package com.sprAnnotation;

import com.sprAnnotation.conf.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by Brian in 7:17 2018/12/12
 */
public class AnnotationTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

    @Test
    public void test() {
        printBean();

        ConfigurableEnvironment environment = context.getEnvironment();
        // 操作系统
        String property = environment.getProperty("os.name");
        // 在运行时参数添加 -Dos.name=Linux, 则获取到 Linux
        System.out.println(property);
    }

    // 测试 import 导入组件
    @Test
    public void testImport() {
        printBean();
    }

    public void printBean(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println(bean);
        }
    }

}
