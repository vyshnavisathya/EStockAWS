package com.cts.estock.authentication.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @NotNull
    @Column (name = "user_name")
    @Size(message = "Username should be atleast 5 characters")
    private String username;

    @NotNull
    @Column (name = "email_id")
    @Valid
    private String emailId;

    @NotNull
    @Column (name = "password")
    @Size(message = "Password should be atleast 5 characters")
    private String password;

    @NotNull
    @Column (name = "confirm_password")
    @Size(message = "ConfirmPassword should be atleast 5 characters")
    private String confirmPassword;

    public User() {
    }

    public User(int id, String username, String emailId, String password, String confirmPassword) {
        this.id = id;
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
