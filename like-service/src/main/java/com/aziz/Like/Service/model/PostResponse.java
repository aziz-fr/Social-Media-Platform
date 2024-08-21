package com.aziz.Like.Service.model;
import com.aziz.Like.Service.entity.LikeTweet;
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
    private LikeTweet like;
}
