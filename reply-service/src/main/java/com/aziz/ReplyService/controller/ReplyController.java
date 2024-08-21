package com.aziz.ReplyService.controller;

import com.aziz.ReplyService.entity.Reply;
import com.aziz.ReplyService.external.client.TweetService;
import com.aziz.ReplyService.model.PostResponse;
import com.aziz.ReplyService.model.ReplyDto;
import com.aziz.ReplyService.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/reply")
public class ReplyController {

  @Autowired
  private ReplyService replyService;

  @Autowired
  private TweetService tweetService;

  @PostMapping("/{tweetId}/add")
  public ResponseEntity<PostResponse> createReply(@PathVariable Long tweetId, @RequestBody ReplyDto reply){
    var reply1 = replyService.createReply(tweetId, reply);
    return new ResponseEntity<>(reply1, HttpStatus.CREATED);
  }

  @GetMapping("/{tweetId}/all")
  public ResponseEntity<List<Reply>> getAllReplyByTweetId(@PathVariable Long tweetId){
    List<Reply> replies = replyService.getAllReplyByTweetId(tweetId);
    return new ResponseEntity<>(replies, HttpStatus.OK);
  }

  @PutMapping("/{tweetId}/{userId}/update/{replyId}")
  public ResponseEntity<Reply> updateReply(@PathVariable Long userId,
                                           @PathVariable Long tweetId,
                                           @PathVariable Long replyId,
                                           @RequestBody Reply updateReply)
  {
    Reply reply = replyService.updateReply(userId,tweetId, replyId, updateReply);
    return new ResponseEntity<>(reply,HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{tweetId}/{userId}/delete/{replyId}")
  public ResponseEntity<String> deleteReply(@PathVariable Long userId, @PathVariable Long tweetId, @PathVariable Long replyId)
  {
    replyService.deleteReply(userId, tweetId, replyId);
    return new ResponseEntity<>("Reply deleted successfully", HttpStatus.NO_CONTENT);
  }

  @GetMapping
  ResponseEntity<List<Reply>> getAllReplies()
  {
    List<Reply> replies = replyService.getAllReplies();
    return new ResponseEntity<>(replies,HttpStatus.OK);
  }
}
