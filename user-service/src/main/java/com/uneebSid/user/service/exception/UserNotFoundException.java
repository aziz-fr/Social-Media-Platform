package com.uneebSid.user.service.exception;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException
{
    public String errorCode;
    public int status;

    public UserNotFoundException(String message, String errorCode, int status)
    {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
