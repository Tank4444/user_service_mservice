package ru.chuikov.mservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chuikov.mservice.entity.User;
import ru.chuikov.mservice.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping( value = "/user", produces ="application/json")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "/get/id/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long id){
        Optional<User> user=userService.getUserById(id);
        if(user.isPresent()) return new ResponseEntity<User>(user.get(),HttpStatus.OK);
            else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/get/username/{username}")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username){
        Optional<User> user=userService.getUserByUsername(username);
        if(user.isPresent()) return new ResponseEntity<User>(user.get(),HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
