package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public Iterable<User> getAllUser(){
        return userService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User userCreated = userService.save(user);
        return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) throws Exception {
        User user = userService.update(id, newUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
