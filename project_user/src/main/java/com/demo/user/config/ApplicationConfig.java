package com.demo.user.config;

import com.demo.user.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtFilter jwtFilter;
    //实现拦截器功能

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(jwtFilter).addPathPatterns("/**").excludePathPatterns("**/login/**");
    }
}
