package com.aziz.tweet.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aziz.tweet.service.entity.Tweet;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
      List<Tweet> findByUserId(Long userId);
}
