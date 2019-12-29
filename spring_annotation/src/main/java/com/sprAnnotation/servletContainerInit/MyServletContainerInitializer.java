package com.sprAnnotation.servletContainerInit;

import com.sprAnnotation.filter.UserFilter;
import com.sprAnnotation.listener.UserListener;
import com.sprAnnotation.service.HelloService;
import com.sprAnnotation.servlet.UserServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 应用启动时，会运行此方法
     *
     * @param set:
     * @param servletContext： 代表当前web 应用的ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类型 ====================");

        for (Class claz : set) {
            System.out.println(claz);
        }

        // 注册 UserServlet
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", new UserServlet());
        userServlet.addMapping("/user");

        // 注册 UserListener
        servletContext.addListener(UserListener.class);

        // 注册 UserFilter
        FilterRegistration.Dynamic userFilter = servletContext.addFilter("userFilter", UserFilter.class);
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
