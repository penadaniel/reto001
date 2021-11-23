/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class UserServices {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> getAll(){
        return repository.getAll();
    }
    public User save(User user){
        if(user.getName() == null || user.getEmail() == null || user.getPassword() == null){
            return user;
        }
        else{
            List<User> existUser = repository.getUserByNameOrEmail(user.getName(),user.getEmail());
            if(!existUser.isEmpty()){
                if(user.getId()==null){
                    return repository.save(user);
                }
                else{
                    Optional<User> existUser2 = repository.getUserById(user.getId());
                    if(!existUser2.isPresent()){
                        return repository.save(user);
                    }
                    else{
                        return user;
                    }
                }
            }
            else{
                return user;
            }
        }
    }
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    public User getByEmailPass(String email, String password){
        Optional<User> userExist = repository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        }
        else{
            return new User(id:null, email, password, name:"NO DEFINIDO");
            //return new User();
        }
    }
    
}

