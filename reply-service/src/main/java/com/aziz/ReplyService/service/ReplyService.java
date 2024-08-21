package com.aziz.ReplyService.service;
import com.aziz.ReplyService.entity.Reply;
import com.aziz.ReplyService.model.PostResponse;
import com.aziz.ReplyService.model.ReplyDto;

import java.util.List;

public interface ReplyService
{
    public PostResponse createReply(Long tweetId, ReplyDto newReply);
    List<Reply> getAllReplies();
    List<Reply> getAllReplyByTweetId(Long tweetId);
    Reply updateReply(Long userId, Long tweetId, Long replyId, Reply updateReply);
    public void deleteReply(Long userId, Long tweetId, Long replyId);
}
