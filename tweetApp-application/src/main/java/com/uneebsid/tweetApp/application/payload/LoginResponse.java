package com.uneebsid.tweetApp.application.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponse
{
    private boolean error;
    private String message;
    private String token;
    private Long id;
    private String username;
}
