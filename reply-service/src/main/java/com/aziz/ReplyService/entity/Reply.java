package com.aziz.ReplyService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(
        name = "replies"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Reply
{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @NotEmpty(message = "reply should not be empty or null")
    @Size(max = 80, message = "reply should not be longer than 80 characters.")
    private String content;

    @Column(name="user_id")
    private Long userId;

    @Column(name="tweet_id")
    private Long tweetId;

}
