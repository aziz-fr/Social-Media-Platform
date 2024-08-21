package com.aziz.Like.Service.exception;

import lombok.Data;

@Data
public class LikeServiceException extends RuntimeException{
  private String errorCode;
  private int status;

  public LikeServiceException(String message, String errorCode, int status)
  {
    super(message);
    this.errorCode=errorCode;
    this.status = status;

  }
}
