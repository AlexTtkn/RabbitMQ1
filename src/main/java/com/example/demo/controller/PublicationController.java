package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.ActivityService;
import com.example.demo.service.PublicationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class PublicationController {

    private final PublicationService publicationService;
    private final ActivityService activityService;

    @Autowired
    public PublicationController(PublicationService publicationService, ActivityService activityService) {
        this.publicationService = publicationService;
        this.activityService = activityService;
    }

    @PostMapping("/publish")
    public String publishPost(@RequestBody Post post) {
        publicationService.publishNewPost(post);
        return "Пост опубликован успешно";
    }

    @PostMapping("/like")
    public String likePost(@RequestParam String postId, @RequestParam String userId) {
        String message = "Пользователь " + userId + " лайкнул пост " + postId;
        activityService.handleNewLike(message);
        return "Лайк обработан успешно";
    }

    @PostMapping("/comment")
    public String commentOnPost(@RequestParam String postId, @RequestParam String userId, @RequestParam String comment) {
        String message = "Пользователь " + userId + " написал комментарий " + postId + ": " + comment;
        activityService.handleNewComment(message);
        return "Коментарий обработан успешно";
    }
}

