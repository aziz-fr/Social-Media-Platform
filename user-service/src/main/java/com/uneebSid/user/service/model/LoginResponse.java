package com.uneebSid.user.service.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginResponse
{
    private boolean error;
    private String message;
    private String token;
    private Long id;
    private String username;
}
