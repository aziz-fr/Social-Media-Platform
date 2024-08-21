package com.aziz.tweet.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(
        name = "tweets"
)
public class Tweet {
  @Id
  @GeneratedValue(
          strategy = GenerationType.IDENTITY
  )
  private long id;

  @Size(max = 144, message = "a tweet cannot have more than 144 characters")
  private String content;

  private Instant date;
  private Long userId;
}
