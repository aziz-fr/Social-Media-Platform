package com.uneebsid.tweetApp.application.controller;


import com.uneebsid.tweetApp.application.entity.User;
import com.uneebsid.tweetApp.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("/api/v1.0/tweets")
@RestController
public class UserController
{

    @Autowired
    UserService userService;

    @GetMapping("/users/all")
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

    @GetMapping("/users/search/{username}")
    public ResponseEntity<User> getUsersByUsername(@PathVariable String username)
    {
        User user = userService.getUsersByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId,@RequestBody User updateUser)
    {
        User user = userService.updateUser(userId, updateUser);
        return new ResponseEntity<>(user,HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/update/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username,@RequestBody User updateUser)
    {
        User user = userService.updateUser(username, updateUser);
        return new ResponseEntity<>(user,HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/users/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.NO_CONTENT);
    }








}
