package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    void getAllUsers(){

        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/users", String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void getSingleUser(){
        int id = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> request = new HttpEntity<User>(headers);
        try {
            ResponseEntity<User> res = restTemplate.exchange("http://localhost:8082/todos/" + id, HttpMethod.GET, request, User.class);
            assertEquals(res.getStatusCode(), HttpStatus.OK);
        }catch (Exception e){
            assertEquals("404 : \"Wrong ID\"",e.getMessage());
        }
    }

    @Test
    void postMappingUser(){
        User user= new User();
        user.setFirstname("TestController");
        user.setLastname("Post");
        user.setEmail("This is Post controller method");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        ResponseEntity<User> res = restTemplate.exchange("http://localhost:8082/users",HttpMethod.POST,request, User.class);
        assertEquals(res.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void putMappingTodo(){
        User user= new User();
        user.setUserid(1);
        user.setFirstname("TestController");
        user.setLastname("Put");
        user.setEmail("This is Put controller method");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        try {
            ResponseEntity<User> res = restTemplate.exchange("http://localhost:8082/users", HttpMethod.PUT, request, User.class);
            assertEquals(res.getStatusCode(), HttpStatus.OK);
        }
        catch (Exception e){
            assertEquals("404 : \"Wrong ID\"",e.getMessage());
        }
    }

    @Test
    void deleteTodoMap(){
        int id=1;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<String>(headers);
        try {
            ResponseEntity res = restTemplate.exchange("http://localhost:8082/users/"+id,HttpMethod.DELETE,request,String.class);
            assertEquals(res.getStatusCode(),HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            assertEquals("404 : \"Wrong ID\"",e.getMessage());
        }

    }

}

