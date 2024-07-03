package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
public class Post {

    private String id;
    private Long like;
    private String content;
    private LocalDateTime timestamp;

}
