package com.akinovap.RabbitMQDefaultExchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/default")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/send/{sender}")
    public String publisher( @PathVariable  String sender){
        CustomMessage customMessage = new CustomMessage();
        customMessage.setId(1);
        customMessage.setSender(sender);
        customMessage.setMessageContent("Hello friends...its time to celebrate our blessings.");
        customMessage.setSentDate(new Date());

        template.convertAndSend(MQConfig.QUEUE, customMessage);
        return " Message sent!";
    }
}
