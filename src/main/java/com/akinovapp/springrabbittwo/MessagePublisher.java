package com.akinovapp.springrabbittwo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/rabbitTwo")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publishMessage")
    public String publishMessage(@RequestBody CustomMessage message){

        message.setMessageID(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
        return "message sent successfully";
    }
}
