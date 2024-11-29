package com.microservice.hotel.service.Hotelservice.repositories;

import com.microservice.hotel.service.Hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {
}
