package com.uneebsid.tweetApp.application.service;

import com.uneebsid.tweetApp.application.entity.Like;
import com.uneebsid.tweetApp.application.entity.User;

import java.util.List;

public interface LikeService
{
    List<Like> getAllLikesByTweetId(Long tweetId);
    public Like likeTweet(Long tweetId, User user);

}
