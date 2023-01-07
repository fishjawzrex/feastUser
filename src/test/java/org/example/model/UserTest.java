package org.example.model;

import org.example.repo.UserRepo;
import org.example.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.example.model.User;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {
    @Autowired
    UserService userServ;
    @Autowired
    private UserRepo userRepo;

        @Test
    public void addUserTest(){
        User testUser = new User("Sally Johnson","sally@email.com");
        User testUser2 = new User("Ben Franklin","ben@email.com");
        userServ.addUser(testUser);
        userServ.addUser(testUser2);
    }
    @Test
    public void testGetAllUsers(){
        Set<User> testSet = userServ.getAllUsers();
        Assertions.assertNotNull(testSet);
    }

    @Test
    public void testGetUserById(){
        User testUser = null;
        try {
            testUser = userServ.getUserById(11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(testUser);
    }

    @Test
    public void testUpdate() throws Exception{
        userServ.updateUser(11,"Albert Franklin", "albert@email.com");
        User testUser = userServ.getUserById(11);
        if(testUser.getUserName().equals("Albert Franklin")){
            System.out.println("passed!");
        }
    }

//    @Test
//    public void testDelete(){
//        userServ.deleteUserByID(12);
//    }
}