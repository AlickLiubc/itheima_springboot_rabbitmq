package com.itheima.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @RabbitListener(queues = "boot_queue")
    public void receiveMessage(Message message) {
        System.out.println(new String(message.getBody()));
    }

}
