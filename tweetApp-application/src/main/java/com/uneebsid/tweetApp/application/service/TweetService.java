package com.uneebsid.tweetApp.application.service;

import com.uneebsid.tweetApp.application.entity.Tweet;
import com.uneebsid.tweetApp.application.payload.PostResponse;
import com.uneebsid.tweetApp.application.payload.TweetDto;

import java.util.List;

public interface TweetService
{
    public List<Tweet> getAllTweets();

    public List<Tweet> getAllTweetsByUserId(Long userId);

    public PostResponse createTweet(Long userId, TweetDto newTweet);

    public Tweet updateTweet(Long userId, Long id, Tweet updateTweet);
    public void deleteTweet(Long userId, Long tweetId);
}
