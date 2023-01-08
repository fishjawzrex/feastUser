package org.example.contoller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userServ;

    @GetMapping("/")
    public String getTest(){
        return "Welcome to Feast Freedom, Please select one of our Kitchens!";
    }
    @GetMapping("/users/all")
    public Set<User> getAllUsers(){
        try {
            Set<User> userSet = userServ.getAllUsers();
//            Set<String> res = userSet.stream().map(user -> user.toString()).collect(Collectors.toSet());
//            String res = userSet.toString();
            return userSet;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @GetMapping("/users/{userID}")
    public User getUserByID(@PathVariable int userID){
        try {
            return userServ.getUserById(userID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/users/findByEmail/{userEmail}")
    public User getUserByEmail(@PathVariable String userEmail){
        try {
            return userServ.findByEmail(userEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/users/update/{userID}")
    public ResponseEntity updateUser(@PathVariable int userID,@RequestBody User user){
        try {
            User tempUser = userServ.getUserById(userID);
            tempUser.setUserName(user.getUserName());
            tempUser.setEmail(user.getEmail());
            tempUser.setPassword(user.getPassword());
            userServ.addUser(tempUser);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/users/register")
    public ResponseEntity registerUser(@RequestBody User user){
        try {
            userServ.addUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
