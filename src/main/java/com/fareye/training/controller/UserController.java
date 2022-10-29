package com.fareye.training.controller;

import com.fareye.training.model.User;
import com.fareye.training.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity getUsers(){
        return new ResponseEntity<>(this.userService.getUsers(),HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Wrong ID",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user){
        return new ResponseEntity(this.userService.addUser(user),HttpStatus.CREATED);
    }

//    @PutMapping("/users/{id}")
//    public ResponseEntity updateUser(@PathVariable("id") int id,@RequestBody User user) throws  Exception{
//        if(!users.containsKey(id)) throw new Exception("This key is not in the System");
//        user.setUserId(id);
//        users.put(id,user);
//        return new ResponseEntity(user,HttpStatus.OK);
//    }

    @PutMapping("/users")
    public ResponseEntity updateUser(@RequestBody User user){
        try {
            return new ResponseEntity(this.userService.updateUser(user),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("Success Deleted User", HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>("Wrong ID",HttpStatus.BAD_REQUEST);
        }

    }
}
