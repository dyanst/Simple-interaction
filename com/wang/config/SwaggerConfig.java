package com.wang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Api Dyanst",
                "起飞",
                "v0.1",
                "http://fysnst.cn/",
                new Contact("wl","http://fysnst.cn/","3421239367@qq.com"),
                "Apache 2.0",
                "",
                new ArrayList());

    }
    @Bean
    //enable:是否启动
    public Docket docket(Environment environment){
        Profiles profiles= Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                //basePackage:扫描包
                .apis(RequestHandlerSelectors.basePackage("com.wang.controller"))
                //过滤路径
                //.paths(PathSelectors.ant("/wang/**"))
                .build();
    }

}
