package com.aziz.Like.Service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "likes")
@Entity
public class Like
{

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Long tweetId;
    private Long replyId;
    private Long userId;

//    @ManyToOne(
//
//    )
//    @JoinColumn(
//            name = "user_id",
//            nullable = false
//    )
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(
//            name = "tweet_id",
//            nullable = false
//    )
//    private Tweet tweet;
//    @ManyToOne
//    @JoinColumn(
//            name = "reply_id",
//            nullable = false
//    )
//    private Reply reply;

}
