package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Customer")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userID;
    private String userName;

    public String getPassword() {
        return password;
    }

    private  String email;

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//    private List<Integer> orderIdList;
}
