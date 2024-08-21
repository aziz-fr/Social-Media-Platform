package com.uneebsid.tweetApp.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(
        name = "replies"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply
{

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;

//    @NotEmpty(message = "userId should not be empty or null")
//    private String userId;

    @NotEmpty(message = "userId should not be empty or null")
    @Email
    private String email;

    @NotEmpty(message = "reply body should not be empty or null")
    @Size(max = 144, message = "reply should be 144 characters or under it.")
    private String body;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "tweet_id",
            nullable = false
    )
    private Tweet tweet;

    @OneToMany(
            mappedBy = "reply",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Like> likes = new HashSet<>();

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn
            (
                    name = "user_Id",
                    nullable = false
            )
    private User user;

}
