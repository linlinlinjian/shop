package com.ssm.shop.config;

import com.ssm.shop.interceptors.UserLoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 访问静态资源
 */
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

    @Autowired
    private UserLoginHandlerInterceptor userLoginHandlerInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/builder/**").addResourceLocations("classpath:/static/","classpath:/builder/","classpath:/builder/static/","classpath:/builder/client/","file:./target/builder/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:/images/");

        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "redirect:http://localhost:8080/builder/client/index.html" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 判断用户是否登录的拦截器
//        registry.addInterceptor(userLoginHandlerInterceptor).addPathPatterns("/**");
//    }
}
