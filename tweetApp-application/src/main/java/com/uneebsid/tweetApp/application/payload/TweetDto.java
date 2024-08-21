package com.uneebsid.tweetApp.application.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TweetDto
{
    private String content;
    private Date date;
}
