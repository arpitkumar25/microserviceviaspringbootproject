package com.microservice.hotel.service.Hotelservice.exceptions;

import com.microservice.hotel.service.Hotelservice.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException1(ResourceNotFoundException ex)
    {
     String message=ex.getMessage();
     APIResponse response=  APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
     return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException ex)
//    {
//        Map map=new HashMap();
//        map.put("message",ex.getMessage());
//        map.put("success",false);
//        map.put("status",HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
////        String message=ex.getMessage();
////        APIResponse response=  APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
////        return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
//    }
}
