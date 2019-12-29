package com.sprAnnotation.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

// 父容器配置类, 只扫描业务逻辑组件, 排除 Controller 组件
@ComponentScan(value = "com.sprAnnotation.mvc.*", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class RootConfig {
}
