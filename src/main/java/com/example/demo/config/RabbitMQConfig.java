package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue newPublicationsQueue() {
        return new Queue("новые_публикации", false);
    }

    @Bean
    public Queue subscriberNotificationsQueue() {
        return new Queue("уведомления_подписчикам", false);
    }

    @Bean
    public Queue likeActivityQueue() {
        return new Queue("новый_лайк", false);
    }

    @Bean
    public Queue commentActivityQueue() {
        return new Queue("новый_комментарий", false);
    }
}
