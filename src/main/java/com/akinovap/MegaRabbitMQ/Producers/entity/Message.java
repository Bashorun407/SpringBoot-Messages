package com.akinovap.MegaRabbitMQ.Producers.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "RabbitMQ_Message")
@ToString
public class Message {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //Had to comment the @GeneratedValue out because the messageId is String. @GeneratedValue is programmed to work with numbers
    private String messageId;
    private String sender;
    private String messageContent;
    private Date messageDate;
}
