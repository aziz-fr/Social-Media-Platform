package com.aziz.Like.Service.service.impl;

import com.aziz.Like.Service.entity.LikeTweet;
import com.aziz.Like.Service.exception.LikeServiceException;
import com.aziz.Like.Service.external.client.TweetService;
import com.aziz.Like.Service.external.client.UserService;
import com.aziz.Like.Service.model.LikeDto;
import com.aziz.Like.Service.model.PostResponse;
import com.aziz.Like.Service.model.TweetRequest;
import com.aziz.Like.Service.model.UserRequest;
import com.aziz.Like.Service.repository.LikeRepository;
import com.aziz.Like.Service.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

  @Autowired
  TweetService tweetService;

  @Autowired
  UserService userService;

  @Autowired
  LikeRepository likeRepository;

  @Override
  public PostResponse likeTweet(Long tweetId, LikeDto newLike) {
//    UserRequest user = userService.getUserById(newLike.getUserId());
//    TweetRequest tweet = tweetService.getTweetById(user.getId(), tweetId);

//    if (likeRepository.findLikesByTweetId(tweet.getId()) != null){
//      throw new IllegalStateException("user has already liked this tweet.");
//    }

    LikeTweet like = new LikeTweet();
    like.setTweetId(newLike.getTweetId());
    like.setUserId(newLike.getUserId());
    LikeTweet savedLike = likeRepository.save(like);

    PostResponse response = new PostResponse();
    response.setLike(savedLike);
    response.setMessage("Tweet liked successfully!");
    response.setError(false);

    return response;
  }

//  @Override
//  public List<LikeTweet> getLikesByTweetId(Long userId, Long tweetId) {
//    UserRequest user = userService.getUserById(userId);
//    TweetRequest tweet = tweetService.getTweetById(user.getId(), tweetId);
//
//    List<LikeTweet> likes = likeRepository.findLikesByTweetId(tweet.getId());
//
//    return likes;
//  }

  @Override
  public List<LikeTweet> getLikesByTweetId(Long tweetId) {
    return likeRepository.findLikesByTweetId(tweetId);
  }

  @Override
  public void deleteLike(Long userId, Long tweetId, Long likeId) {
    TweetRequest tweet = tweetService.getTweetById(userId, tweetId);
    LikeTweet like = likeRepository.findById(likeId)
            .orElseThrow(() -> new LikeServiceException("Like not found with id: " + likeId, "NOT_FOUND", 404));

    if (!tweet.getId().equals(like.getTweetId())){
      throw new RuntimeException("Like id does not correspondent to this tweet id");
    }

    likeRepository.delete(like);
  }

}
//import com.uneebsid.tweetApp.application.entity.Like;
//import com.uneebsid.tweetApp.application.entity.Tweet;
//import com.uneebsid.tweetApp.application.entity.User;
//import com.uneebsid.tweetApp.application.repository.LikeRepository;
//import com.uneebsid.tweetApp.application.repository.TweetRepository;
//import com.uneebsid.tweetApp.application.service.LikeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

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
