package com.akinovap.MegaRabbitMQ.Producers.messagePublisher;

import com.akinovap.MegaRabbitMQ.Producers.entity.Message;
import com.akinovap.MegaRabbitMQ.Producers.entity.MessageDto;
import com.akinovap.MegaRabbitMQ.Producers.messageService.MessageService;
import com.akinovap.MegaRabbitMQ.ResponsePojo.ResponsePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/megaMessage")
public class MessagePublisher {

    @Autowired
    private MessageService messageService;

    @PostMapping("/publishMessage")
    public ResponsePojo<Message> publisher(@RequestBody MessageDto messageDto){

        return messageService.publishMessage(messageDto);
    }
}
