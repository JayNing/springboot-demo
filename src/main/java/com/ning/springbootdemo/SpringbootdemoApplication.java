package com.ning.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class SpringbootdemoApplication {

    /**
     * 添加 @ServletComponentScan 注解，为了启动服务器时，执行监听器里的内容
     * 添加 @EnableScheduling 注解，为了定时任务类能够执行
     * **/

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }



}
