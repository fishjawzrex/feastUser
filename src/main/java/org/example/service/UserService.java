package org.example.service;

import org.example.model.User;
import org.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Set<User> getAllUsers(){
        Set<User> userSet = new HashSet<>();
        List<User> userList = userRepo.findAll();
        for (User user: userList){
            userSet.add(user);
        }
        System.out.println(userSet);
        return userSet;
    }

    public User getUserById(int userID){
        Optional<User> optionalUser = userRepo.findById(userID);
        User concreteUser;
        if(optionalUser.isPresent()){
            concreteUser = optionalUser.get();
        }else{
            System.out.println("no such user with id: "+userID);
            return null;
        }
        System.out.println("success!");
        return concreteUser;
    }

    public void updateUser(int userID, String newName, String newEmail){
        try {
//            Set<User> userSet = this.getAllUsers();
//            List<User> userList = userSet.stream().filter(user -> user.getUserID()==userID).collect(Collectors.toList());
            User user = getUserById(userID);
            user.setUserName(newName);
            user.setEmail(newEmail);
            System.out.println("user updated!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteUserByID(int userID){
        try {
            User user = getUserById(userID);
            String name = user.getUserName();
            userRepo.delete(user);
            System.out.println(name+" deleted!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findByEmail(String email){
        try {
            Set<User> userSet = getAllUsers();
            for(User user : userSet){
                if(email==user.getEmail()){
                    return user;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("user not found :( "+email);
        return null;
    }


}
