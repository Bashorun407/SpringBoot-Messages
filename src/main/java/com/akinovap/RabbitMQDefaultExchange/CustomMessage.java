package com.akinovap.RabbitMQDefaultExchange;

import lombok.Data;

import java.util.Date;

@Data
public class CustomMessage {

    private  int id;
    private String sender;
    private String messageContent;
    private Date sentDate;
}
