package com.wang.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/root").setViewName("indexLogin");
        registry.addViewController("/main.html").setViewName("Bem/Display-page/indexAdmin");
        registry.addViewController("/main.html").setViewName("Bem/Display-page/indexAdmin");
        registry.addViewController("/other.html").setViewName("Bem/Display-page/indexadmin-extend");
        registry.addViewController("/nas.html").setViewName("Bem/Display-page/indexadmin-Nas");
        registry.addViewController("/pss.html").setViewName("Bem/Display-page/indexadmin-setup");
        registry.addViewController("/blogAdd.html").setViewName("Bem/Function-page/indexadmin-blog-add");
        registry.addViewController("/friendAdd.html").setViewName("Bem/Function-page/indexaddmin-friend-add");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login", "/css/**","/fonts/**","/img/**","/js/**","/root");
    }




}
