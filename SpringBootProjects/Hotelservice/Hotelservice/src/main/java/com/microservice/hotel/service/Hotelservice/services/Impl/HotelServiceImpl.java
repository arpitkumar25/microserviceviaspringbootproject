package com.microservice.hotel.service.Hotelservice.services.Impl;

import com.microservice.hotel.service.Hotelservice.entities.Hotel;
import com.microservice.hotel.service.Hotelservice.repositories.HotelRepo;
import com.microservice.hotel.service.Hotelservice.services.HotelService;
import com.microservice.hotel.service.Hotelservice.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        //Generate Random Hotel Id
        String randomHotelId= UUID.randomUUID().toString();
        hotel.setHotelId(randomHotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepo.findById(hotelId).
                orElseThrow(
                        () -> new ResourceNotFoundException("The Hotel Id is not available:"+hotelId)
                );
    }
}
