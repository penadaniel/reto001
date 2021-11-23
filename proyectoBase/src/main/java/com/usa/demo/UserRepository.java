/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserInterface repository;
    
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }
    public User save(User user){
        return repository.save(user);
    }
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
    public List<User> getUserByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }
    public Optional<User> getUserEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }
}
