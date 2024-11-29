package com.microservice.user.service.Userservice.services;

import com.microservice.user.service.Userservice.entities.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userid);


}
