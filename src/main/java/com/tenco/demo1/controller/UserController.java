package com.tenco.demo1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo1.model.User;
import com.tenco.demo1.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	// http://localhost:80/users/sign-up 
    @PostMapping("/sign-up")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }  

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name ="id") Long id) {
    	System.out.println("동작확인");
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    @GetMapping("/list")
    public List<User> getAllMembers() {
    	return userService.getAllUsers();
    }
}
