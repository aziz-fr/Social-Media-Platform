package com.aziz.Like.Service.controller;

import com.aziz.Like.Service.entity.LikeTweet;
import com.aziz.Like.Service.external.client.TweetService;
import com.aziz.Like.Service.external.client.UserService;
import com.aziz.Like.Service.model.LikeDto;
import com.aziz.Like.Service.model.PostResponse;
import com.aziz.Like.Service.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/like")
public class LikeController {
  @Autowired
  private LikeService likeService;

  @Autowired
  private TweetService tweetService;

  @Autowired
  private UserService userService;

  @PostMapping("/{tweetId}/add")
  public ResponseEntity<PostResponse> likeTweet(@PathVariable Long tweetId, @RequestBody LikeDto like){
    var like1 = likeService.likeTweet(tweetId, like);
    return new ResponseEntity<>(like1, HttpStatus.CREATED);
  }

//  @GetMapping("/{userId}/{tweetId}/all")
//  public ResponseEntity<List<LikeTweet>> getAllLikesByTweetId(@PathVariable Long userId, @PathVariable Long tweetId){
//    List<LikeTweet> likes = likeService.getLikesByTweetId(userId, tweetId);
//    return new ResponseEntity<>(likes, HttpStatus.OK);
//  }

  @GetMapping("/{tweetId}/all")
  public ResponseEntity<List<LikeTweet>> getAllLikesByTweetId(@PathVariable Long tweetId){
    List<LikeTweet> likes = likeService.getLikesByTweetId(tweetId);
    return new ResponseEntity<>(likes, HttpStatus.OK);
  }

  @DeleteMapping("/{tweetId}/{userId}/delete/{likeId}")
  public ResponseEntity<String> deleteLike(@PathVariable Long userId, @PathVariable Long tweetId, @PathVariable Long likeId){
    likeService.deleteLike(userId, tweetId, likeId);
    return new ResponseEntity<>("Like deleted successfully", HttpStatus.NO_CONTENT);
  }
}
