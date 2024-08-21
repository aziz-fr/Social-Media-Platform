package com.uneebsid.tweetApp.application.payload;
import com.uneebsid.tweetApp.application.entity.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse
{
    private boolean error;
    private String message;
    private Tweet tweet;
}
