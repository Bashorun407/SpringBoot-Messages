package com.akinovap.MegaRabbitMQ.Producers.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDto {

    private String messageId;
    private String sender;
    private String messageContent;
    private Date messageDate;
}
