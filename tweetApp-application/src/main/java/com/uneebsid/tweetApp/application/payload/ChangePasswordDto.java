package com.uneebsid.tweetApp.application.payload;

import com.uneebsid.tweetApp.application.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePasswordDto
{
    private String username;
    private String password;
    private String confirmPassword;
}
