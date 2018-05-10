package com.company.project.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by chengwengao on 2018/5/10.
 */
@Component
public class Consumer2 {
    @JmsListener(destination = "myQueue")
    @SendTo("outQueue") //将return回的值，再发送的"outQueue"队列中
    public String receiveQueue(String text){
        System.out.println("Consumer2收到消息："+text);
        return "return msg:"+text;
    }
}
