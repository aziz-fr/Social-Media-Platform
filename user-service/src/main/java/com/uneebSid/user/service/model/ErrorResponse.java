package com.uneebSid.user.service.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ErrorResponse
{
    private String errorMessage;
    private String errorCode;
}
