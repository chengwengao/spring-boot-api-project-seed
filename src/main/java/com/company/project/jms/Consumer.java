package com.company.project.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**消费者
 * Created by chengwengao on 2018/5/8.
 */
//@Component
public class Consumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "myQueue1")
    public void recieveQueue(String text){
        System.out.println("Consumer收到消息："+text);
    }
}
