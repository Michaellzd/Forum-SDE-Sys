package com.demo.test.ProductTest;

import com.demo.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*@Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("itcast","直接模式测试");
    }

    @Test
    public void sendMsg2(){
        rabbitTemplate.convertAndSend("chuanzhi","","分裂模式");
    }
    @Test
    public void sendMsg3(){
        rabbitTemplate.convertAndSend("itcast","直接模式测试");
    }*/

    @Test
    public void testSendTopic(){
        rabbitTemplate.convertAndSend("topictest","goods.bbbbbbb","主题模式");
    }

    @Test
    public void testSendTopic2(){
        rabbitTemplate.convertAndSend("topictest","abccc.log","主题模式2222");
    }

    @Test
    public void testSendTopic3(){
        rabbitTemplate.convertAndSend("topictest","goods.log","主题模式3333");
    }
}
