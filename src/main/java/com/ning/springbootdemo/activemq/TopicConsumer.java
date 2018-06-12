package com.ning.springbootdemo.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者2
 *
 * @author ning
 * @create 2018-06-12 15:26
 **/
@Component
public class TopicConsumer {
    /**
     * 消息消费者的类上必须加上@Component，或者是@Service，这样的话，消息消费者类就会被委派给Listener类，原理类似于使用SessionAwareMessageListener以及MessageListenerAdapter来实现消息驱动POJO
     * @param text
     */
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.topic")
    public void receiveTopic(String text) {
        System.out.println("TopicConsumer收到的报文为:"+text);
    }
}