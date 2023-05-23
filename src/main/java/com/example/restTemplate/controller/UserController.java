package com.example.restTemplate.controller;

import com.example.restTemplate.Services.UserService;
import com.example.restTemplate.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id){
        User user=userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@Valid@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user));
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }
}
