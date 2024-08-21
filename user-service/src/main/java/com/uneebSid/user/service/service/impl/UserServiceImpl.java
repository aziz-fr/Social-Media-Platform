package com.uneebSid.user.service.service.impl;

import com.uneebSid.user.service.service.UserService;
import com.uneebSid.user.service.repository.UserRepository;
import com.uneebSid.user.service.entity.User;
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

    // changed updateUser to updateUserById
    // added all the fields to update
    @Override
    public User updateUserById(Long userId, User userDetails)
    {
        User userById = userRepository
                .findById(userId)
                .orElseThrow(()-> new RuntimeException("user does not exist with id: " + userId));

        userById.setFirstName(userDetails.getFirstName());
        userById.setLastName(userDetails.getLastName());
        userById.setUsername(userDetails.getUsername());
        userById.setEmail(userDetails.getEmail());
        userById.setPassword(userDetails.getPassword());
        userById.setPhoneNumber(userDetails.getPhoneNumber());

        return userRepository.save(userById);
    }

    // changed updateUser to updateUserByUsername
    // added all the fields to update
    @Override
    public User updateUserByUsername(String username, User userDetails) {
        User userByName = userRepository
                .findByUsername(username)
                .orElseThrow(()-> new RuntimeException("user does not exist with username:" + username));

        userByName.setFirstName(userDetails.getFirstName());
        userByName.setLastName(userDetails.getLastName());
        userByName.setUsername(userDetails.getUsername());
        userByName.setEmail(userDetails.getEmail());
        userByName.setPassword(userDetails.getPassword());
        userByName.setPhoneNumber(userDetails.getPhoneNumber());

        return userRepository.save(userByName);
    }

    @Override
    public void deleteUser(Long userId)
    {
        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new RuntimeException("user does not exist by id: " + userId));

        userRepository.delete(user);

    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }
}

