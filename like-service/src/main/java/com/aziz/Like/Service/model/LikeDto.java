package com.aziz.Like.Service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LikeDto {
  private Long tweetId;
  private Long userId;
}
