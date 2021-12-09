package com.cts.estock.authentication.controller;


import com.cts.estock.authentication.exception.UserAlreadyExist;
import com.cts.estock.authentication.exception.UserNotFoundException;
import com.cts.estock.authentication.model.User;
import com.cts.estock.authentication.repository.UserRepository;
import com.cts.estock.authentication.service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1.0/market")
public class UserController {

    @Autowired
    private UserImpl userImpl;

    @PostMapping("/add/user")
    public User addUser(@RequestBody User user) throws UserAlreadyExist {
        Optional<User> checkUser = Optional.ofNullable(userImpl.getUserByEmailId(user.getEmailId()));
        if(checkUser.isPresent()) {
            throw new UserAlreadyExist("User Already exist!! Try with some other emailId");
        }
        return userImpl.addUser(user);
    }

    @GetMapping("/authenticate/{emailId}/{password}")
    public boolean authenticateUser(@PathVariable String emailId, @PathVariable String password) throws UserNotFoundException {
        System.out.print("emailId {}"+emailId);
        System.out.print("password {}"+password);
        User checkUser = userImpl.loadUserByEmailId(emailId);
        System.out.print("User {}"+checkUser);
        if(checkUser.getPassword().equals(password)) {
            System.out.print("Authemtication success");
            return true;

        } else {
            return false;
        }
    }

    @GetMapping("get/user")
    public List<User> getAllUser(){
        return userImpl.getAllUser();
    }
}
