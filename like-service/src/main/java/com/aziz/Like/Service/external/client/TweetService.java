package com.aziz.Like.Service.external.client;

import com.aziz.Like.Service.model.TweetRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TWEET-SERVICE/api/v1.0/tweets")
public interface TweetService {
  @GetMapping("/{userId}/{tweetId}")
  public TweetRequest getTweetById(@PathVariable Long userId, @PathVariable Long tweetId);

  @GetMapping("/{tweetId}")
  public TweetRequest getTweetByIdOnly(@PathVariable Long tweetId);
}
