package com.fareye.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobelExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElementExceptionHandler(NoSuchElementException ex) {
        String msg = ex.getMessage();
        System.out.println(msg);
        return new ResponseEntity("Wrong ID", HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public ResponseEntity<List> methdodArgumentNotValidException(final MethodArgumentNotValidException ex) {
//        List list = ex.getBindingResult().getAllErrors().stream()
//                .map(fieldError -> fieldError.getDefaultMessage())
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        Map<String,String> res = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            res.put(fieldName,message);
        });
        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
}
