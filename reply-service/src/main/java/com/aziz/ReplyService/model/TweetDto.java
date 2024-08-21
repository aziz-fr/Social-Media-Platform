package com.aziz.ReplyService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TweetDto
{
    private String content;
    private Long userId;

}
