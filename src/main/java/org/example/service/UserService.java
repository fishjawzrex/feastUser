package org.example.service;

import org.example.model.User;
import org.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void addUser(User user){
        try{
            userRepo.save(user);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("saved user: "+user.getUserName());
    }
}
