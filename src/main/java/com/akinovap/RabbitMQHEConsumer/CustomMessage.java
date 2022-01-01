package com.akinovap.RabbitMQHEConsumer;

import lombok.Data;

import java.util.Date;

@Data
public class CustomMessage {

    private String messageID;
    private String sender;
    private String messageBody;
    private Date sentDate;
}
