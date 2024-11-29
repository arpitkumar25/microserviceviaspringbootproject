package com.microservice.hotel.service.Hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource is not found on Server");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
