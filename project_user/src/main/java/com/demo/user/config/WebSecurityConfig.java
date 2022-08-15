package com.demo.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //author所有security全注解配置实现的开端
        //需要的权限由两部分，第一是拦截的路径，第二部分是需要的权限
        // .antMatchers("/**").permitAll()
        // .anyRequest().authenticated()认证后才能访问
                     //   .and().csrf().disable(); 固定写法，表示使得csrf拦截失效

        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
