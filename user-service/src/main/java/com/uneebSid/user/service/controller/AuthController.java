//package com.uneebSid.user.service.controller;
//
//import com.uneebSid.user.service.model.*;
//import com.uneebSid.user.service.service.AuthService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//@CrossOrigin
//@RestController
//@RequestMapping("/api/v1.0/auth")
//public class AuthController
//{
//    @Autowired
//    AuthService authService;
//
//    @PostMapping(value = {"/login", "/signin"})
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto)
//    {
//        var response = authService.login(loginDto);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping(value = {"/register", "/signup"})
//    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterDto registerDto)
//    {
//        var response = authService.register(registerDto);
//        return  ResponseEntity.ok(response);
//    }
//
//    @PutMapping("/setpassword")
//    public ResponseEntity<ChangePasswordResponse> changePassword(@RequestBody ChangePasswordDto changePasswordDto)
//    {
//        var response = authService.changePassword(changePasswordDto);
//        return ResponseEntity.ok(response);
//    }
//}
