package com.ning.springbootdemo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestSchedule {

    private static Logger logger = LoggerFactory.getLogger(TestSchedule.class);

    @Scheduled(initialDelay = 1000, fixedDelay = 1000)
    public void test(){
        logger.info("我是定时器测试日志，时间：" + new Date());
    }

}