package com.example.hotelManager.config;

import com.example.hotelManager.config.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

public class WebConfigurer implements WebMvcConfigurer {
    //配置静态资源的，比如html，js,css等等
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {

    }
    //写好的拦截器必须放在这里才有效
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
         registry.addInterceptor(loginInterceptor).addPathPatterns("/**/").excludePathPatterns("/login");


    }
}
