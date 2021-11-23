/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController implements Serializable{
    @Autowired
    private UserServices service;
    
    @GetMapping("/all")
    public List<User> getUser(){
        return service.getAll();
    }
    
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }
    
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getByEmailPass(email, password);
    }
}

