package com.uneebsid.tweetApp.application.service;


import com.uneebsid.tweetApp.application.entity.Reply;

public interface ReplyService
{
    Reply createReply(Long userId, Long tweetId, Reply newReply);

}
