package com.conpany.project.activemq;

import com.company.project.jms.Producer;
import com.conpany.project.Tester;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chengwengao on 2018/5/9.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringbootJmsApplicationTests extends Tester{

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException{

        javax.jms.Destination destination = new ActiveMQQueue("myQueue");

        for (int i = 0; i < 10; i++){
            producer.sendMessage(destination, "number is :" + i);
        }
    }
}
