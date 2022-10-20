package com.fareye.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.io.*;

@RestController
public class PropertyController {

    Properties p;

    public PropertyController(){
        p = new Properties();
        try {
            p.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            System.out.println("This is reader Exception");
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/properties/{env}")
    public Properties properties(@PathVariable String env){
        return (Properties) p.get(env);
    }

}
