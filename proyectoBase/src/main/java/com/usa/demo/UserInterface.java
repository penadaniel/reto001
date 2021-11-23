/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USER
 */
public interface UserInterface extends CrudRepository<User,Integer> {
    
    public Optional<User> findByName(String name);
    
    public Optional<User> findByEmail(String email);
    
    public List<User> findByNameOrEmail(String name, String email);
    
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}