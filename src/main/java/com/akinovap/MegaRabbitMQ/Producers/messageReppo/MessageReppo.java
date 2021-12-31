package com.akinovap.MegaRabbitMQ.Producers.messageReppo;

import com.akinovap.MegaRabbitMQ.Producers.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageReppo extends JpaRepository<Message, String> {
}
