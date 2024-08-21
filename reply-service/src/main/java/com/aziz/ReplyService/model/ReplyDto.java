package com.aziz.ReplyService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyDto {
  private Long userId;
  private Long tweetId;
  private String content;
  private Instant date;
}
