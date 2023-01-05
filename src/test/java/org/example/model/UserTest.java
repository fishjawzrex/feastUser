package org.example.model;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.example.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {
    @Autowired
    UserService userServ;
    @Test
    public void addUserTest(){
        User testUser = new User("Laura Shelly","laura@email.com");
        User testUser2 = new User("Ben Franklin","ben@email.com");
        userServ.addUser(testUser);
        userServ.addUser(testUser2);
    }
}