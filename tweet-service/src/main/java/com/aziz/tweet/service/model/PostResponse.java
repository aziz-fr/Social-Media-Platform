package com.aziz.tweet.service.model;
import com.aziz.tweet.service.entity.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse
{
    private boolean error;
    private String message;
    private Tweet tweet;
}
