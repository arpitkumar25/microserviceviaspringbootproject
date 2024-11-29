package com.microservice.user.service.Userservice.services.Impl;

import com.microservice.user.service.Userservice.entities.User;
import com.microservice.user.service.Userservice.exceptions.ResourceNotFoundException;
import com.microservice.user.service.Userservice.repositories.UserRepo;
import com.microservice.user.service.Userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        //generate unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userid) {
        return userRepo.findById(userid).
                orElseThrow(() -> new ResourceNotFoundException("User ID Details not found:"+userid));
    }
}
