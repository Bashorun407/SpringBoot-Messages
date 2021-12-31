package com.akinovap.MegaRabbitMQ.Producers.messageService;

import com.akinovap.MegaRabbitMQ.Producers.entity.Message;
import com.akinovap.MegaRabbitMQ.Producers.entity.MessageDto;
import com.akinovap.MegaRabbitMQ.Producers.messageConfiguration.MQConfig;
import com.akinovap.MegaRabbitMQ.Producers.messageReppo.MessageReppo;
import com.akinovap.MegaRabbitMQ.ResponsePojo.ResponsePojo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class MessageService {

    @Autowired
    private MessageReppo messageReppo;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ResponsePojo<Message> publishMessage(MessageDto messageDto){

        Message message = new Message();
        message.setMessageId(UUID.randomUUID().toString());
        message.setSender(messageDto.getSender());
        message.setMessageContent(messageDto.getMessageContent());
        message.setMessageDate(new Date());

        messageReppo.save(message);//Saving the new Data into MessageReppo Repository
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, messageDto);

        ResponsePojo<Message> responsePojo = new ResponsePojo<>();
        responsePojo.setData(message);
        responsePojo.setMessage("Message published successfully");
        return responsePojo;
    }
}
