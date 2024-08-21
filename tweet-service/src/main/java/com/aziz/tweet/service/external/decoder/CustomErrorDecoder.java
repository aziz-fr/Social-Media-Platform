package com.aziz.tweet.service.external.decoder;

import com.aziz.tweet.service.exception.TweetServiceException;
import com.aziz.tweet.service.model.ErrorDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder
{
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();


        try
        {
            ErrorDetail errorDetail = objectMapper.readValue(response.body()
                    .asInputStream(),  ErrorDetail.class);
            return new TweetServiceException(errorDetail.getErrorMessage(),
                                errorDetail.getErrorCode(), response.status());
        }
        catch (IOException e)
        {
            throw new TweetServiceException("Internal Server Error","INTERNAL_SERVER_ERROR",500);
        }

    }
}
