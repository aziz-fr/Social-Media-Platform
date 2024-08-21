package com.uneebsid.tweetApp.application.repository;

import com.uneebsid.tweetApp.application.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long>
{
//    @Query("SELECT l from Like l where l.user.Id=user_Id AND l.tweet.Id=tweet_Id")
//    public Like isLikeExist(@Param("user_Id") Long user_Id, @Param("tweet_Id") Long tweet_Id);
//
//    @Query("SELECT l from Like l where l.tweet.Id = tweet_Id")
//    Optional<List<Like>>  findByTweetId(@Param("tweet_Id") Long tweet_Id);

}
