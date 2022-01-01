package com.akinovap.RabbitMQHeaderExchange;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/header")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;
    @PostMapping("/publishMessage/{sender}")
    public String publisher(@PathVariable String sender){
//        CustomMessage message1 = new CustomMessage();
//        message1.setMessageID(UUID.randomUUID().toString());
//        message1.setSender(sender);
//        message1.setMessageBody("Happy New Year...enjoy the new year in much wealth.");
//        message1.setSentDate(new Date());

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("color", sender);
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(sender, messageProperties);

        template.send(MessageConfig.EXCHANGE, " ", message);
        return " Message sent!!";
    }
}
