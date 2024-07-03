package com.example.demo.service;

import com.example.demo.model.Post;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Log4j2
public class PublicationService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PublicationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishNewPost(Post post) {
        log.info(String.format("Публикую новый пост -> %s", post.getContent()));
        post.setId(UUID.randomUUID().toString());
        post.setTimestamp(LocalDateTime.now());
        rabbitTemplate.convertAndSend("новые_публикации", post.getContent());
    }


}
