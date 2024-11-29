package com.microservice.rating.service.RatingService.controllers;

import com.microservice.rating.service.RatingService.entities.Rating;
import com.microservice.rating.service.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/ratingservice")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //Create Post Rating API
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        Rating rating1 = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    //Create Get Rating API to fetch all Ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating()
    {
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    //Create Get Rating API to Rating by User Id
    @GetMapping("/User/{UserId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String UserId)
    {
        System.out.println("Inside Rating by User ID Controller");
        return ResponseEntity.ok(ratingService.getRatingByUser(UserId));
    }


    //Create Get Rating API to Rating by Hotel Id
    @GetMapping("/Hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingByHotel(hotelId));
    }


}
