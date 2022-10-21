package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import com.fareye.training.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;

@RestController
public class UserController {

    HashMap<Integer,User>users = new HashMap<Integer,User>();
    int UserID;

    public HashMap<Integer, User> getUserData(){
        return users;
    }

    @GetMapping("/users")
    public ResponseEntity getUsers(){
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable("id") int id){
        return new ResponseEntity<>(users.get(id),HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody @NotNull User user){
        user.setUserId(UserID);
        users.put(UserID++,user);
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity updateUser(@PathVariable("id") int id,@RequestBody User user) throws  Exception{
        if(!users.containsKey(id)) throw new Exception("This key is not in the System");
        user.setUserId(id);
        users.put(id,user);
        return new ResponseEntity(user,HttpStatus.OK);
    }

//    @DeleteMapping("/users/{id}")
//    public HashMap<Integer, User> deleteUser(@PathVariable("id") int id) throws Exception{
//        if(!users.containsKey(id)) throw new Exception("This key is not in the System");
//        users.remove(id);
//        return users;
//    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        users.remove(id);
       return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
