package com.akinovap.RabbitMQHeaderExchange;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CustomMessage {

    private String messageID;
    private String sender;
    private String messageBody;
    private Date sentDate;
}
