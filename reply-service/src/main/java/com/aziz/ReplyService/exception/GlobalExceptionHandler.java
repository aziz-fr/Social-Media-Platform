//package com.aziz.ReplyService.exception;
//
//import com.aziz.tweet.service.model.ErrorDetail;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
//{
//    public ResponseEntity<ErrorDetail> handleTweetNotFoundException(ReplyServiceException ex)
//    {
//        ErrorDetail errorDetail = ErrorDetail.builder()
//                .errorCode(ex.getErrorCode())
//                .errorMessage(ex.getMessage())
//                .build();
//
//        return new ResponseEntity<>(errorDetail, HttpStatusCode.valueOf(ex.getStatus()));
//    }
//}
