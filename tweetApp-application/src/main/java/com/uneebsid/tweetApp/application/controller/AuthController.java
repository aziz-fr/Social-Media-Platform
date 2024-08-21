package com.uneebsid.tweetApp.application.controller;

import com.uneebsid.tweetApp.application.payload.*;
import com.uneebsid.tweetApp.application.repository.UserRepository;
import com.uneebsid.tweetApp.application.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/auth")
public class AuthController
{
    @Autowired
    AuthService authService;

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto)
    {
        var response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterDto registerDto)
    {
        var response = authService.register(registerDto);
        return  ResponseEntity.ok(response);
    }

    @PutMapping("/setpassword")
    public ResponseEntity<ChangePasswordResponse> changePassword(@RequestBody ChangePasswordDto changePasswordDto)
    {
        var response = authService.changePassword(changePasswordDto);
        return ResponseEntity.ok(response);
    }

}
