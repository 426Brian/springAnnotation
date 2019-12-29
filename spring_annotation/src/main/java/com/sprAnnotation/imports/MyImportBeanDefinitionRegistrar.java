package com.sprAnnotation.imports;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata: 当前类的注解信息
     * @param registry：BeanDefinition 注册类, 把需要添加到容器中的bean, 调用registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
     *                手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean redDef = registry.containsBeanDefinition("com.sprAnnotation.bean.Blue");
        boolean blueDef = registry.containsBeanDefinition("com.sprAnnotation.bean.Color");
        
        if(redDef && blueDef){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition("com.sprAnnotation.bean.RainBow");
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
