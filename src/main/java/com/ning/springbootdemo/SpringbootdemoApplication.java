package com.ning.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableCaching
public class SpringbootdemoApplication {

    /**
     * 添加 @ServletComponentScan 注解，为了启动服务器时，执行监听器里的内容
     * 添加 @EnableScheduling 注解，为了定时任务类能够执行
     * 添加 @EnableCaching 注解，为了开启缓存功能
     * **/

//    @Bean
//    public Queue queue() {
//        return new ActiveMQQueue("mytest.queue");
//    }
//
//    @Bean
//    public Topic topic() {
//        return new ActiveMQTopic("mytest.topic");
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }



}


