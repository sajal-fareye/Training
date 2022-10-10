package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class UserController {

    HashMap<Integer,User>users = new HashMap<Integer,User>();
    int UserID;

    @GetMapping("/users")
    public HashMap<Integer, User> hello(){
        return users;
    }

    @PostMapping("/users")
    public HashMap<Integer, User> createUser(@RequestBody User user){
        user.setUserId(UserID);
        users.put(UserID++,user);
        return users;
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") int id,@RequestBody User user) throws  Exception{
        if(!users.containsKey(id)) throw new Exception("This key is not in the System");
        user.setUserId(id);
        users.put(id,user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public HashMap<Integer, User> deleteUser(@PathVariable("id") int id) throws Exception{
        if(!users.containsKey(id)) throw new Exception("This key is not in the System");
        users.remove(id);
        return users;
    }
}
