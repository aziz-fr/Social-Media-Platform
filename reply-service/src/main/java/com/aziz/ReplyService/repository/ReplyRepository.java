package com.aziz.ReplyService.repository;

import com.aziz.ReplyService.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
  List<Reply> findAllReplyByTweetId(Long tweetId);
}
