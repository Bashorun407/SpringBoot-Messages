package com.akinovap.MegaRabbitMQ.ResponsePojo;

import lombok.Data;

@Data
public class ResponsePojo <T>{
    Boolean success = true;
    String message;
    T data;
    int status = 200;
}
