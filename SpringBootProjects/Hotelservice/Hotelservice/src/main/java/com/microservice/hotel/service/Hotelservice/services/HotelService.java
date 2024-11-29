package com.microservice.hotel.service.Hotelservice.services;

import com.microservice.hotel.service.Hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {

    //Create Hotel
    Hotel createHotel(Hotel hotel);

    //Get All Hotel
    List<Hotel> getAllHotel();

    //Get 1 Hotel
    Hotel getHotel(String hotelId);
}
