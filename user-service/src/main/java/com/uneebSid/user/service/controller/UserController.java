package com.uneebSid.user.service.controller;


import com.uneebSid.user.service.entity.User;
import com.uneebSid.user.service.model.*;
import com.uneebSid.user.service.service.AuthService;
import com.uneebSid.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("/api/v1.0/users")
@RestController
public class UserController
{
    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    @PostMapping(value = {"/auth/login", "/auth/signin"})
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto)
    {
        var response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = {"/auth/register", "/auth/signup"})
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterDto registerDto)
    {
        var response = authService.register(registerDto);
        return  ResponseEntity.ok(response);
    }

    @PutMapping("/auth/setpassword")
    public ResponseEntity<ChangePasswordResponse> changePassword(@RequestBody ChangePasswordDto changePasswordDto)
    {
        var response = authService.changePassword(changePasswordDto);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id)
    {
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getALLUsers()
    {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody User newUser)
    {
        User user = userService.addUser(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @GetMapping("/search/{username}")
    public ResponseEntity<User> getUsersByUsername(@PathVariable String username)
    {
        User user = userService.getUsersByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // update by user id is not working
    // changed updateUser to updateUserById
    // update by id works
    @PutMapping("/update/id/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable("userId") Long userId, @RequestBody User updateUser)
    {
        User user = userService.updateUserById(userId, updateUser);
        return new ResponseEntity<>(user,HttpStatus.NO_CONTENT);

    }

    // update by username is also not working
    // path "/users/" being repeated
    // @PutMapping("/users/update/{username}")
    // changed updateUser to updateUserByUsername
    // update by username works
    @PutMapping("/update/username/{username}")
    public ResponseEntity<User> updateUserByUsername(@PathVariable("username") String username, @RequestBody User updateUser)
    {
        User user = userService.updateUserByUsername(username, updateUser);
        return new ResponseEntity<>(user,HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.NO_CONTENT);
    }

}
