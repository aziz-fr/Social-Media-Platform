package com.aziz.tweet.service.exception;

import lombok.Data;

@Data
public class TweetServiceException extends RuntimeException
{
    private String errorCode;
    private int status;

    public TweetServiceException(String message, String errorCode, int status)
    {
        super(message);
        this.errorCode=errorCode;
        this.status = status;

    }
}
