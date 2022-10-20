package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import com.fareye.training.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class UserController {

    HashMap<Integer,User>users = new HashMap<Integer,User>();
    int UserID;

    @GetMapping("/users")
    public HashMap<Integer, User> getUsers(){
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id){
        return users.get(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody @NotNull User user){
        user.setUserId(UserID);
        users.put(UserID++,user);
        return users.get(UserID-1);
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
