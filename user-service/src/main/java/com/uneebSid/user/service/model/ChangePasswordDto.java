package com.uneebSid.user.service.model;
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

