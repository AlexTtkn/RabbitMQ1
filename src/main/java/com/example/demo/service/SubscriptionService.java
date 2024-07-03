package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SubscriptionService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public SubscriptionService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "новые_публикации")
    public void handleNewPublication(String post) {
        log.info(String.format("Обработка новой побликации -> %s", post));
        rabbitTemplate.convertAndSend("уведомления_подписчикам", post);
    }
}
