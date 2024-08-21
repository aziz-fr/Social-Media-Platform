package com.uneebsid.tweetApp.application.service;

import com.uneebsid.tweetApp.application.entity.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();

    User getUsersByUsername(String username);
    User addUser(User newUser);
    User updateUser(Long userId, User user);
    User updateUser(String username, User user);
    void deleteUser(Long userId);
}
