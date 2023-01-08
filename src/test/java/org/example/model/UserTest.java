package org.example.model;

import org.example.repo.UserRepo;
import org.example.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.example.model.User;

import java.util.List;
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
        User testUser = new User("admin","billy@email.com","password","ADMIN",
                true,false,false,false);
//        User testUser2 = new User("Ben Franklin","ben@email.com");
//        User testUser3 = new User("Mary Johnson","mary@email.com");
//        User testUser4 = new User("James Barkley","james@email.com");
//        User testUser5= new User("Samuel Adams","sadams@email.com");
//        User testUser6 = new User("Andrew Jackson","ajack@email.com");
//            userServ.addUser(testUser);
//            userServ.addUser(testUser6);
//            userServ.addUser(testUser2);
//            userServ.addUser(testUser3);
//            userServ.addUser(testUser4);
//            userServ.addUser(testUser5);

    }
//    @Test
//    public void testGetAllUsers(){
//        Set<User> testSet = userServ.getAllUsers();
//        Assertions.assertNotNull(testSet);
//    }
//
//    @Test
//    public void testGetUserById(){
//        User testUser = null;
//        try {
//            testUser = userServ.getUserById(16);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        Assertions.assertNotNull(testUser);
//    }

//    @Test
//    public void testUpdate() throws Exception{
//        userServ.updateUser(11,"Albert Franklin", "albert@email.com");
//        User testUser = userServ.getUserById(11);
//        if(testUser.getUserName().equals("Albert Franklin")){
//            System.out.println("passed!");
//        }
//    }
    @Test
    public void testGetUserByUserName(){
        try {
            User testUser = userServ.findByUserName("admin");
            System.out.println(testUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    @Test
//    public void testDelete(){
//        userServ.deleteUserByID(12);
//    }
}