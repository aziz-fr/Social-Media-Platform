package com.uneebsid.tweetApp.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name = "tweets"
)
public class Tweet
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;


    @Size(max = 144, message = "a tweet can not have more than 144 characters")
    private String content;

    private Date date = new Date();

    @ManyToOne(
        fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_id"
    )
    private User user;


    @OneToMany(
            mappedBy = "tweet",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<Reply> replies = new HashSet<>();

    @OneToMany(
            mappedBy = "tweet",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<Like> likes = new HashSet<>();

}
