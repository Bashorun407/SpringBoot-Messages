package com.akinovap.RabbitMQDefExConsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message){
        log.info("Message received is: " + message.getMessageContent() + " from: " + message.getSender());

    }
}
