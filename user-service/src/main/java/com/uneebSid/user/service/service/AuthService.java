package com.uneebSid.user.service.service;

import com.uneebSid.user.service.model.*;

public interface AuthService
{
    LoginResponse login(LoginDto loginDto);
    RegisterResponse register(RegisterDto registerDto);
    ChangePasswordResponse changePassword(ChangePasswordDto changePasswordDto);
}
