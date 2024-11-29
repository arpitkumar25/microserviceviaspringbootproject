package com.microservice.rating.service.RatingService.services;

import com.microservice.rating.service.RatingService.entities.Rating;
import java.util.List;

public interface RatingService {

    //Create Rating
    Rating createRating(Rating rating);

    //Get All Rating
    List<Rating> getAllRating();

    //Get Rating by User ID
    List<Rating> getRatingByUser(String userId);

    //Get rating by Hotel Id
    List<Rating> getRatingByHotel(String hotelId);
}
