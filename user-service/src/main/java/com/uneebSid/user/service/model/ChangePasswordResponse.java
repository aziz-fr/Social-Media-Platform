package com.uneebSid.user.service.model;

import com.uneebSid.user.service.entity.User;
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

