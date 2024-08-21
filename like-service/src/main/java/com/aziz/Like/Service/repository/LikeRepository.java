package com.aziz.Like.Service.repository;

import com.aziz.Like.Service.entity.LikeTweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeTweet, Long>
{
  List<LikeTweet> findLikesByTweetId(Long tweetId);
}
