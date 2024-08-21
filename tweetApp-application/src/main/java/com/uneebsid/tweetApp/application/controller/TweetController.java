package com.uneebsid.tweetApp.application.controller;

import com.uneebsid.tweetApp.application.entity.Tweet;
import com.uneebsid.tweetApp.application.payload.PostResponse;
import com.uneebsid.tweetApp.application.payload.TweetDto;
import com.uneebsid.tweetApp.application.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/tweets")
public class TweetController
{
    @Autowired
    private TweetService tweetService;

    @GetMapping("/all")
    public ResponseEntity<List<Tweet>> getAllTweets()
    {
        List<Tweet> tweets = tweetService.getAllTweets();
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Tweet>> getTweetsByUserId(@PathVariable Long userId)
    {
        List<Tweet> tweets = tweetService.getAllTweetsByUserId(userId);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<PostResponse> createTweet(@PathVariable Long userId, @RequestBody TweetDto tweet)
    {
        var tweet1 = tweetService.createTweet(userId, tweet);
        return new ResponseEntity<>(tweet1, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}/update/{tweetId}")
    public ResponseEntity<Tweet> updateTweet(@PathVariable Long userId,
                                             @PathVariable Long tweetId,
                                             @RequestBody Tweet updateTweet)
    {
        Tweet tweet = tweetService.updateTweet(userId,tweetId,updateTweet);
        return new ResponseEntity<>(tweet,HttpStatus.NO_CONTENT);
    }

@DeleteMapping("/{userId}/delete/{tweetId}")
    public ResponseEntity<String> deleteTweet(@PathVariable Long userId,@PathVariable Long tweetId)
    {
        tweetService.deleteTweet(userId, tweetId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.NO_CONTENT);
    }

}
