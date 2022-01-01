package com.akinovap.RabbitMQHEConsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {
    @RabbitListener(queues = MessageConfig.QUEUE)
    public void listener(String message){
        log.info("Message received from:  " + message);
    }
}
