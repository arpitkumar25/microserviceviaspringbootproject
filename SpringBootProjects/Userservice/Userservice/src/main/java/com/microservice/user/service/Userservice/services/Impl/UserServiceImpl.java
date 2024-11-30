package com.microservice.user.service.Userservice.services.Impl;

import com.microservice.user.service.Userservice.entities.Rating;
import com.microservice.user.service.Userservice.entities.User;
import com.microservice.user.service.Userservice.exceptions.ResourceNotFoundException;
import com.microservice.user.service.Userservice.repositories.UserRepo;
import com.microservice.user.service.Userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingClient ratingClient;

    @Override
    public User saveUser(User user) {
        //generate unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = userRepo.findAll();

        List<User> newUserList = users.stream().map(user -> {
            user.setRatings(ratingClient.getRatingByUserId(user.getUserId()));
            return user;
        }).collect(Collectors.toList());

        return users;
    }

    @Override
    public User getUser(String userid) {
        User user= userRepo.findById(userid).
                orElseThrow(() -> new ResourceNotFoundException("User ID Details not found:"+userid));

        System.out.println("For User Id:"+user.getUserId());

        //Using Feign Client
        user.setRatings(ratingClient.getRatingByUserId(user.getUserId()));

        /* Using RestTemplate
        //Call Rating MicroService to get that User Rating Info
        ArrayList<Rating> ratingsOfUser= restTemplate.getForObject("http://RATINGSERVICE/api/v1/ratingservice/User/"+user.getUserId(), ArrayList.class);
        System.out.println(ratingsOfUser);
        user.setRatings(ratingsOfUser);
        */

        return  user;
    }
}
