package com.uneebsid.tweetApp.application.service.impl;

import com.uneebsid.tweetApp.application.entity.User;
import com.uneebsid.tweetApp.application.repository.UserRepository;
import com.uneebsid.tweetApp.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUsersByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()->new RuntimeException("Resource not found"));
    }

    @Override
    public User addUser(User newUser) {

        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(Long userId, User updateUser)
    {
        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new RuntimeException("Resource Not found"));

        user.setUsername(updateUser.getUsername());
        user.setPassword(updateUser.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId)
    {
        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new RuntimeException("Resource Not found"));

        userRepository.delete(user);

    }

    @Override
    public User updateUser(String username, User user) {
        User user1 = userRepository
                .findByUsername(username)
                .orElseThrow(()-> new RuntimeException("Resource Not found"));

       // user.setUsername(user1.getUsername());
        user.setPassword(user1.getPassword());

        return userRepository.save(user);

    }
}
