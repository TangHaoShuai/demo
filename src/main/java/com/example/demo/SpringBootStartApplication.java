package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/** 备注
 * 使用内嵌的tomcat时SpringbootdemoApplication的main方法启动的方式
 这里需要类似于web.xml的配置方式来启动spring上下文，因此重写SpringBootServletInitializer的configure方法，在Application类的同级添加一个SpringBootStartApplication类
 */

public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

}
