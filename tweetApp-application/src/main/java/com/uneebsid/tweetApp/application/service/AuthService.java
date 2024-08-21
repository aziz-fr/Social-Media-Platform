package com.uneebsid.tweetApp.application.service;

import com.uneebsid.tweetApp.application.payload.*;

public interface AuthService
{
    LoginResponse login(LoginDto loginDto);
    RegisterResponse register(RegisterDto registerDto);

    ChangePasswordResponse changePassword(ChangePasswordDto changePasswordDto);
}
