package com.aziz.ReplyService.service.impl;

import com.aziz.ReplyService.entity.Reply;
import com.aziz.ReplyService.exception.ReplyServiceException;
import com.aziz.ReplyService.external.client.TweetService;
import com.aziz.ReplyService.external.client.UserService;
import com.aziz.ReplyService.model.PostResponse;
import com.aziz.ReplyService.model.ReplyDto;
import com.aziz.ReplyService.model.TweetRequest;
import com.aziz.ReplyService.model.UserRequest;
import com.aziz.ReplyService.repository.ReplyRepository;
import com.aziz.ReplyService.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService
{
    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @Override
    public PostResponse createReply(Long tweetId, ReplyDto newReply) {
        UserRequest user = userService.getUserById(newReply.getUserId());
        TweetRequest tweet = tweetService.getTweetById(tweetId);

        if(tweet == null || user == null)
        {
            throw new RuntimeException("Not found");
        }

        Reply reply = new Reply();
        reply.setId(newReply.getUserId());
        reply.setTweetId(newReply.getTweetId());
        reply.setUserId(newReply.getUserId());
        reply.setContent(newReply.getContent());
        Reply savedReply = replyRepository.save(reply);

        PostResponse response = new PostResponse();
        response.setReply(savedReply);
        response.setMessage("Reply posted");
        response.setError(false);

        return response;
    }

    @Override
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    @Override
    public List<Reply> getAllReplyByTweetId(Long tweetId) {
        return replyRepository.findAllReplyByTweetId(tweetId);
    }

    @Override
    public Reply updateReply(Long userId, Long tweetId, Long replyId, Reply updateReply) {
        UserRequest user = userService.getUserById(userId);
        TweetRequest tweet = tweetService.getTweetById(tweetId);

        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(()->new ReplyServiceException("Reply not found with id: "+ replyId, "NOT_FOUND",404));

        // need to add check to see if reply belongs to a tweet

        reply.setContent(updateReply.getContent());
        return replyRepository.save(reply);
    }

    @Override
    public void deleteReply(Long userId, Long tweetId, Long replyId) {
        TweetRequest tweet = tweetService.getTweetById(tweetId);
        Reply reply = replyRepository.findById(replyId).orElseThrow(()-> new ReplyServiceException("Reply not found with id: "+ replyId, "NOT_FOUND",404));
        if(tweet.getId() != reply.getTweetId())
        {
            throw new RuntimeException("Reply does not belong to the Tweet: " + tweetId);
        }

        replyRepository.delete(reply);
    }


}
