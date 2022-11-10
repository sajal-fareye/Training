package com.fareye.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        return "Welcome to Todo App";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return "You are authenticated as " + authentication.getName();
    }

    @RequestMapping(value = "/admin/user/{username}", method = RequestMethod.GET)
    public UserDetails getListOfUser(@PathVariable String username){
        return userDetailsService.loadUserByUsername(username);
    }

//    @PostMapping("/log")
//    public ResponseEntity authenticateUser(@RequestBody LoginRequest loginRequest){
//        System.out.println("Login Request\n" +loginRequest);
//        System.out.println(loginRequest.getUserName());
//
//        try {
//             ProviderManager providerManager = new ProviderManager();
//
//            Authentication authentication = providerManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getUserPassword()));
//
//            User user = (User) authentication.getPrincipal();
//
//            return ResponseEntity.ok().body(user);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>("login is not working", HttpStatus.BAD_REQUEST);
//        }
//
//    }

}

//@Getter
//@Setter
//class LoginRequest{
//    String userName;
//    String userPassword;
//
//}