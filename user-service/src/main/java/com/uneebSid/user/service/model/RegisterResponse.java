package com.uneebSid.user.service.model;
import com.uneebSid.user.service.entity.User;
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
