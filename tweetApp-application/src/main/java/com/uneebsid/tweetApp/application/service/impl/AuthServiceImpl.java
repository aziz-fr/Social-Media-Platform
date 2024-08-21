package com.uneebsid.tweetApp.application.service.impl;

import com.uneebsid.tweetApp.application.entity.User;
import com.uneebsid.tweetApp.application.payload.*;
import com.uneebsid.tweetApp.application.repository.UserRepository;
import com.uneebsid.tweetApp.application.security.JwtTokenProvider;
import com.uneebsid.tweetApp.application.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService
{

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Override
    public LoginResponse login(LoginDto loginDto)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(()->new RuntimeException("user not found"));

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setId(user.getId());
        loginResponse.setUsername(user.getFirstName()+user.getLastName());
        loginResponse.setMessage("login successful");
        loginResponse.setError(false);

        return loginResponse;
    }

    @Override
    public RegisterResponse register(RegisterDto registerDto)
    {
        if(userRepository.existsByUsername(registerDto.getUsername()))
        {
            throw new RuntimeException("Username already exists");
        }

        if(userRepository.existsByEmail(registerDto.getEmail()))
        {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setPhoneNumber(registerDto.getPhoneNumber());

        User savedUser = userRepository.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setUser(savedUser);
        response.setMessage("Registered successfully");
        response.setError(false);

        return response;
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordDto changePasswordDto)
    {
        User user = userRepository.findByUsername(changePasswordDto.getUsername())
                .orElseThrow(()->new RuntimeException("Account does not exist with provided username"));

        user.setPassword(passwordEncoder.encode(changePasswordDto.getPassword()));
        User savedUser = userRepository.save(user);
        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setUser(savedUser);
        response.setMessage("Password successfully changed!");
        response.setError(false);
        return response;
    }
}
