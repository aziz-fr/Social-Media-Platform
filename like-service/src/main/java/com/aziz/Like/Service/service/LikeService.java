package com.aziz.Like.Service.service;

import com.aziz.Like.Service.entity.LikeTweet;
import com.aziz.Like.Service.model.LikeDto;
import com.aziz.Like.Service.model.PostResponse;

import java.util.List;

public interface LikeService
{
    public PostResponse likeTweet(Long tweetId, LikeDto like);
//    List<LikeTweet> getLikesByTweetId(Long userId, Long tweetId);
    List<LikeTweet> getLikesByTweetId(Long tweetId);
    public void deleteLike(Long userId, Long TweetId, Long likeId);
}
