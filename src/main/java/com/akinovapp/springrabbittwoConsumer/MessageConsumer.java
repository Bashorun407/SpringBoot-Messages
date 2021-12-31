package com.akinovapp.springrabbittwoConsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message){
        System.out.println(message);
    }
}
