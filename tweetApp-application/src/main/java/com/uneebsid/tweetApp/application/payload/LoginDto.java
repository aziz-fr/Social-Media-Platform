package com.uneebsid.tweetApp.application.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto
{
    private String username;
    private String password;
}
