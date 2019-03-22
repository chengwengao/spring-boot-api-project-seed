package com.company.project.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;


/**消息生产者
 * Created by chengwengao on 2018/5/8.
 */
//@Service("producer")
public class Producer {

    // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(javax.jms.Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
