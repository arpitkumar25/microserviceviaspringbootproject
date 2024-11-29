package com.microservice.user.service.Userservice.externalservices;

import com.microservice.user.service.Userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

    @GetMapping("/User/{UserId}")
    public List<Rating> getRating(@PathVariable String UserId);

}
