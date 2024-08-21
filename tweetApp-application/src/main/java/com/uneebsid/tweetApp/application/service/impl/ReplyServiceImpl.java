package com.uneebsid.tweetApp.application.service.impl;

import com.uneebsid.tweetApp.application.entity.Reply;
import com.uneebsid.tweetApp.application.entity.Tweet;
import com.uneebsid.tweetApp.application.repository.ReplyRepository;
import com.uneebsid.tweetApp.application.repository.TweetRepository;
import com.uneebsid.tweetApp.application.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService
{
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    TweetRepository tweetRepository;
    @Override
    public Reply createReply(Long userId, Long tweetId, Reply newReply)
    {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(()-> new RuntimeException("Tweet Not found"));
        Reply reply = replyRepository.save(newReply);
        tweet.getReplies().add(reply);
        tweetRepository.save(tweet);
        return replyRepository.save(newReply);
    }





}
