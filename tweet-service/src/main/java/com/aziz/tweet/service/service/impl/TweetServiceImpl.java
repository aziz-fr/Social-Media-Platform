package com.aziz.tweet.service.service.impl;

import com.aziz.tweet.service.entity.Tweet;
import com.aziz.tweet.service.exception.TweetServiceException;
import com.aziz.tweet.service.external.client.UserService;
import com.aziz.tweet.service.model.PostResponse;
import com.aziz.tweet.service.model.UserRequest;
import com.aziz.tweet.service.repository.TweetRepository;
import com.aziz.tweet.service.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aziz.tweet.service.model.TweetDto;

import java.time.Instant;
import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {
  @Autowired
  TweetRepository tweetRepository;

  @Autowired
  UserService userService;

  @Override
  public List<Tweet> getAllTweets() {
    return tweetRepository.findAll();
  }

  @Override
  public List<Tweet> getAllTweetsByUserId(Long userId)
  {
    return tweetRepository.findByUserId(userId);
  }

  @Override
  public Tweet getTweetById(Long tweetId) {
    return tweetRepository.findById(tweetId).orElseThrow(()->new TweetServiceException("tweet not found with id: "+tweetId,"NOT_FOUND",404));
  }

  @Override
  public Tweet getSingleTweetByUserId(Long userId, Long tweetId) {
    UserRequest user = userService.getUserById(userId);
    Tweet tweet = tweetRepository.findById(tweetId)
            .orElseThrow(() -> new RuntimeException("tweet id not found"));
    if (user.getId() != tweet.getUserId()){
      throw new RuntimeException("tweet does not belong user");
    }

    return tweet;
  }

  @Override
  public PostResponse createTweet(Long userId, TweetDto newTweet)
  {
    UserRequest user = userService.getUserById(userId);

    if(user.getId() == null || user.getId()!= newTweet.getUserId())
    {
      throw new RuntimeException("Tweet does not belong to the User: " + userId);
    }

    Tweet tweet = new Tweet();
    tweet.setUserId(newTweet.getUserId());
    tweet.setContent(newTweet.getContent());
    tweet.setDate(Instant.now());
    Tweet savedTweet = tweetRepository.save(tweet);

    PostResponse response = new PostResponse();
    response.setTweet(savedTweet);
    response.setMessage("Tweet posted.");
    response.setError(false);
    return response;
  }

  @Override
  public Tweet updateTweet(Long userId, Long id, Tweet updateTweet)
  {
    UserRequest user = userService.getUserById(userId);

    Tweet tweet = tweetRepository.findById(id)
            .orElseThrow(()->new TweetServiceException("Tweet not found with id: "+id, "NOT_FOUND",404));
    if(user.getId() != tweet.getUserId())
    {
      throw new RuntimeException("Tweet does not belong to the User: " + userId);
    }
    tweet.setContent(updateTweet.getContent());
    return tweetRepository.save(tweet);
  }

  @Override
  public void deleteTweet(Long userId, Long tweetId)
  {
    UserRequest user = userService.getUserById(userId);
    Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(()-> new TweetServiceException("Tweet not found with id: "+ tweetId, "NOT_FOUND",404));
    if(user.getId() != tweet.getUserId())
    {
      throw new RuntimeException("Tweet does not belong to the User: " + userId);
    }

    tweetRepository.delete(tweet);
  }
}
