package com.uneebSid.user.service.service;

import com.uneebSid.user.service.entity.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();

    User getUserById(Long userId);
    User getUsersByUsername(String username);
    User addUser(User newUser);
    User updateUserById(Long userId, User user);
    User updateUserByUsername(String username, User user);
    void deleteUser(Long userId);
}