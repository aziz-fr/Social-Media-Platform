package com.uneebsid.tweetApp.application.payload;

import com.uneebsid.tweetApp.application.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChangePasswordResponse
{
    private String message;
    private User user;
    private boolean error;
}
