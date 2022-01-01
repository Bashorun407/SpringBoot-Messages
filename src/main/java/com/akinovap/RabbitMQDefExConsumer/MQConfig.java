package com.akinovap.RabbitMQDefExConsumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String QUEUE = "default_queue";
    public static final String EXCHANGE = "default_exchange";
    public static final String ROUTING_KEY = "default_routing_key";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public HeadersExchange exchange(){
        return new HeadersExchange(EXCHANGE);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }
}
