package com.aziz.tweet.service.service;

import com.aziz.tweet.service.entity.Tweet;
import com.aziz.tweet.service.model.PostResponse;
import com.aziz.tweet.service.model.TweetDto;

import java.util.List;

public interface TweetService {
  public List<Tweet> getAllTweets();

  public List<Tweet> getAllTweetsByUserId(Long userId);

  public Tweet getSingleTweetByUserId(Long userId, Long tweetId);

  public PostResponse createTweet(Long userId, TweetDto newTweet);

  public Tweet updateTweet(Long userId, Long id, Tweet updateTweet);
  public void deleteTweet(Long userId, Long tweetId);

  Tweet getTweetById(Long tweetId);
}
