package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    void postMappingUserControllerTest(){

        User myUser = new User("sajal","Agrawal","sajal@mail");
        User serverUser=restTemplate.postForObject("http://localhost:8082/users", myUser, User.class);
        assertEquals(myUser.getEmail(),serverUser.getEmail());
    }

    @Test
    void getMappingUserControllerTest(){
        User myUser = new User("sajal","Agrawal","sajal.agrawal38@gmail.com");
        User serverUser = restTemplate.getForObject("http://localhost:8082/users/0", User.class);
        assertEquals(myUser.getEmail(),serverUser.getEmail());
    }

    @Test
    void putMappingUserControllerTest(){
        User myUser = new User("Sajal","Agrawal","sajal@mail");
        restTemplate.put("http://localhost:8082/users/0",myUser);
        User serverUser = restTemplate.getForObject("http://localhost:8082/users/0", User.class);
        assertEquals(myUser.getEmail(),serverUser.getEmail());
    }

    @Test
    void deleteMappingUserControllerTest(){
        restTemplate.delete("http://localhost:8082/users/0");
    }

}

