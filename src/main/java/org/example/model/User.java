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

    public User(String userName, String email, String password, String role, boolean isEnabled, boolean isAccountLocked, boolean isAccountExpired, boolean isCredentialExpired) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isEnabled = isEnabled;
        this.isAccountLocked = isAccountLocked;
        this.isAccountExpired = isAccountExpired;
        this.isCredentialExpired = isCredentialExpired;
    }

    private  String email;
    private String password;
    private String role;
    private boolean isEnabled;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        isAccountLocked = accountLocked;
    }

    public boolean isAccountExpired() {
        return isAccountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        isAccountExpired = accountExpired;
    }

    public boolean isCredentialExpired() {
        return isCredentialExpired;
    }

    public void setCredentialExpired(boolean credentialExpired) {
        isCredentialExpired = credentialExpired;
    }

    private  boolean isAccountLocked;
    private boolean isAccountExpired;
    private boolean isCredentialExpired;

    public User() {
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
