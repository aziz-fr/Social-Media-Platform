package com.aziz.tweet.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TweetDto
{
    private String content;
    private Long userId;

}
