package com.aziz.ReplyService.external.client;

import com.aziz.ReplyService.model.TweetRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TWEET-SERVICE/api/v1.0/tweets")
public interface TweetService {
  @GetMapping("/get/{tweetId}")
  public TweetRequest getTweetById( @PathVariable Long tweetId);
}
