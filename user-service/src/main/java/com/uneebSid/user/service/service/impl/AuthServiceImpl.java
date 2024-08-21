package com.uneebSid.user.service.service.impl;

import com.uneebSid.user.service.entity.User;
import com.uneebSid.user.service.exception.UserNotFoundException;
import com.uneebSid.user.service.model.*;
import com.uneebSid.user.service.repository.UserRepository;
import com.uneebSid.user.service.security.JwtTokenProvider;
import com.uneebSid.user.service.service.AuthService;
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
    private JwtTokenProvider jwtTokenProvider;
    @Override
    public LoginResponse login(LoginDto loginDto)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        User user = userRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(()->new UserNotFoundException("User not found with username: "+loginDto.getUsername(),
                        "NOT_FOUND",404));

        LoginResponse response = LoginResponse.builder()
                .error(false)
                .id(user.getId())
                .message("login successful")
                .token(token)
                .username(user.getUsername())
                .build();

        return response;
    }

    @Override
    public RegisterResponse register(RegisterDto registerDto)
    {
        RegisterResponse response = new RegisterResponse();

        if(userRepository.existsByUsername(registerDto.getUsername()))
        {
            response.setError(true);
            response.setMessage("Username Already exist");
            return response;
        }

        if ((userRepository.existsByEmail(registerDto.getEmail())))
        {
            response.setError(true);
            response.setMessage("Email Already exist");
            return response;

        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setPhoneNumber(registerDto.getPhoneNumber());

        User savedUser = userRepository.save(user);



        response.setUser(savedUser);
        response.setMessage("Registered Successfully!");
        response.setError(false);

        return response;
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordDto changePasswordDto)
    {
        User user = userRepository.findByUsername(changePasswordDto.getUsername())
                .orElseThrow(()-> new UserNotFoundException("User not found with username: " +
                        changePasswordDto.getUsername(),"NOT_FOUND",404));
        user.setPassword(passwordEncoder.encode(changePasswordDto.getPassword()));

        User savedUser = userRepository.save(user);

        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setUser(savedUser);
        response.setMessage("Password changed Successfully!");
        response.setError(false);

        return response;
    }
}
