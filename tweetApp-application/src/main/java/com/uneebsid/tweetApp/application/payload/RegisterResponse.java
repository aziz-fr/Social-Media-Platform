package com.uneebsid.tweetApp.application.payload;

import com.uneebsid.tweetApp.application.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResponse
{
    private boolean error;
    private String message;
    private User user;
}
