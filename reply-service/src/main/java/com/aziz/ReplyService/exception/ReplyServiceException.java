package com.aziz.ReplyService.exception;

import lombok.Data;

@Data
public class ReplyServiceException extends RuntimeException
{
    private String errorCode;
    private int status;

    public ReplyServiceException(String message, String errorCode, int status)
    {
        super(message);
        this.errorCode=errorCode;
        this.status = status;

    }
}
