package com.aziz.Like.Service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TweetRequest {
  private Long id;
  private String content;
  private Date date;
  private Long userId;
}
