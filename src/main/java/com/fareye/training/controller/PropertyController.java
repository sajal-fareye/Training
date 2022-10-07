package com.fareye.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.io.*;

@RestController
public class PropertyController {

    Properties p;

    PropertyController(){
        p = new Properties();
        try {
            p.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            System.out.println("THis is reader Exception");
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/properties")
    public Properties properties(){
        return p;
    }

}
