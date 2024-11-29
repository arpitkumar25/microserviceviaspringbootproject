package com.microservice.rating.service.RatingService.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource was not found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
