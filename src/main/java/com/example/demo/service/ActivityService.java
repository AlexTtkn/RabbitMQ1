package com.example.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ActivityService {

    @RabbitListener(queues = "новый_лайк")
    public void handleNewLike(String message) {
        log.info(String.format("Получен новый лайк -> %s", message));


    }

    @RabbitListener(queues = "новый_комментарий")
    public void handleNewComment(String message) {
        log.info(String.format("Получен новый комментарий -> %s", message));
    }
}
