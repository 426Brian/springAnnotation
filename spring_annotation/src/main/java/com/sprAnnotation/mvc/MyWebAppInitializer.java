package com.sprAnnotation.mvc;


import com.sprAnnotation.mvc.config.AppConfig;
import com.sprAnnotation.mvc.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// web 容器启动时候创建对象; 调用方法来初始化容器和前端控制器
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 获取根容器配置类（类似spring 配置文件） 父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }


    // 获取web容器配置类（类似springmvc 配置文件） 子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // 获取DispatcherServlet 映射信息 拦截所有请求, 但是不包括静态资源   不包括*.jsp
    // 拦截方式设置为(/*)时会拦截  *.jsp,  所以应该设置为(/), jsp 由tomcat servlet 引擎解析
    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }


}
