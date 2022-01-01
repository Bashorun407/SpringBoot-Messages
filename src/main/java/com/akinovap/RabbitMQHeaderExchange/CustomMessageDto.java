package com.akinovap.RabbitMQHeaderExchange;

import lombok.Data;

import java.util.Date;

@Data
public class CustomMessageDto {

    private String messageID;
    private String sender;
    private String messageBody;
    private Date sentDate;
}
