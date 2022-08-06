package com.demo.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "itthree")
public class Customer3 {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("itthree:"+msg);
    }
}