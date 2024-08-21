package com.uneebsid.tweetApp.application.service.impl;

//import com.uneebsid.tweetApp.application.entity.Like;
//import com.uneebsid.tweetApp.application.entity.Tweet;
//import com.uneebsid.tweetApp.application.entity.User;
//import com.uneebsid.tweetApp.application.repository.LikeRepository;
//import com.uneebsid.tweetApp.application.repository.TweetRepository;
//import com.uneebsid.tweetApp.application.service.LikeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class LikeServiceImpl implements LikeService
//{
//    @Autowired
//    TweetRepository tweetRepository;
//    @Autowired
//    LikeRepository likeRepository;
//    @Override
//    public List<Like> getAllLikesByTweetId(Long tweetId)
//    {
//        List<Like> likes = likeRepository.findByTweetId(tweetId)
//                .orElseThrow(()->new RuntimeException("tweet not found!"));
//
//        return likes;
//    }
//
//    @Override
//    public Like likeTweet(Long tweetId, User user)
//    {
//        Like like = likeRepository.isLikeExist(user.getId(), tweetId);
//        if(like!=null)
//        {
//            likeRepository.deleteById(like.getId());
//            return like;
//        }
//
//        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(()->new RuntimeException("tweet not found"));
//        Like like1 = new Like();
//        like1.setTweet(tweet);
//        like1.setUser(user);
//        Like savedLike = likeRepository.save(like1);
//        tweet.getLikes().add(savedLike);
//        tweetRepository.save(tweet);
//
//        return savedLike;
//    }
//}
