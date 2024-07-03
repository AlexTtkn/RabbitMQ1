package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class NotificationService {

    @RabbitListener(queues = "уведомления_подписчикам")
    public void sendNotifications(String message) {
        log.info(String.format("Посылаю уведомление -> %s", message));

    }

}
