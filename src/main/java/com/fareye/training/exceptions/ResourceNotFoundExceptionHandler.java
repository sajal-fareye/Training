package com.fareye.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ResourceNotFoundExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElementExceptionHandler(NoSuchElementException ex){
        String msg = ex.getMessage();
        System.out.println(msg);
        return new ResponseEntity("Wrong ID", HttpStatus.NOT_FOUND);
    }
}
