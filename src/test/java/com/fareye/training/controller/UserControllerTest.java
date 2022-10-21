package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    RestTemplate restTemplate = new RestTemplate();
    UserController cout = new UserController();



//    @Test
//    void postMappingUserControllerTest(){
//
//        User myUser = new User("sajal","Agrawal","sajal@mail");
//        User serverUser=restTemplate.postForObject("http://localhost:8082/users", myUser, User.class);
//        assertEquals(myUser.getEmail(),serverUser.getEmail());
//        assertEquals(myUser.getFirstName(),serverUser.getFirstName());
//        assertEquals(myUser.getLastName(),serverUser.getLastName());
//    }

    @Test
    void postMappingUserTest(){
        User myUser = new User("sajal","Agrawal","sajal@mail");
        ResponseEntity res = cout.createUser(myUser);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }


//    @Test
//    void getMappingUserControllerTest(){
//        User myUser = new User("sajal","Agrawal","sajal.agrawal38@gmail.com");
//        User serverUser = restTemplate.getForObject("http://localhost:8082/users/0", User.class);
//        assertEquals(myUser.getEmail(),serverUser.getEmail());
//        assertEquals(myUser.getFirstName(),serverUser.getFirstName());
//        assertEquals(myUser.getLastName(),serverUser.getLastName());
//    }

    @Test
    void getMappingUserTest(){
        int idToBeDeleted = 0;
        ResponseEntity res = cout.getUser(idToBeDeleted);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getMappingAllUserTest(){
        ResponseEntity res = cout.getUsers();
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }


//    @Test
//    void putMappingUserControllerTest(){
//        User myUser = new User("Sajal","Agrawal","sajal@mail");
//        restTemplate.put("http://localhost:8082/users/0",myUser);
//        User serverUser = restTemplate.getForObject("http://localhost:8082/users/0", User.class);
//        assertEquals(myUser.getEmail(),serverUser.getEmail());
//        assertEquals(myUser.getFirstName(),serverUser.getFirstName());
//        assertEquals(myUser.getLastName(),serverUser.getLastName());
//    }

    @Test
    void putMappingUserControllerTest() throws Exception {
        int idToBeDeleted = 0;
        User myUser = new User("Sajal","Agrawal","sajal@mail");
        try {
            ResponseEntity res = cout.updateUser(idToBeDeleted,myUser);
            assertEquals(res.getStatusCode(), HttpStatus.OK);
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"This key is not in the System");
        }
    }


    @Test
    void deleteMappingUserControllerTest(){
//        String url = "http://localhost:8082/users/0";


//        User myUser = new User("Sajal","Agrawal","sajal@mail");
//        HttpEntity<User> httpEntity = new HttpEntity<>(myUser,"success");
//        ResponseEntity<Void> responseEntity=restTemplate.exchange(url,HttpMethod.DELETE,httpEntity,void.class);


        int idToBeDeleted = 0;

        ResponseEntity res = cout.deleteUser(idToBeDeleted);
        assertEquals(res.getStatusCode(), HttpStatus.NO_CONTENT);
        assertEquals(cout.getUserData().containsKey(idToBeDeleted),false);

    }

}

