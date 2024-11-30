package com.microservice.user.service.Userservice.services.Impl;

import com.microservice.user.service.Userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@FeignClient(url = "http://localhost:8083" , name= "RATING-SERVICE")
@FeignClient(name = "RATING-SERVICE")
@RestController
public interface RatingClient {

@GetMapping("/api/v1/ratingservice/User/{UserId}")
List<Rating> getRatingByUserId(@PathVariable String UserId);

}
