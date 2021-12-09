package com.cts.estock.authentication.service;

import com.cts.estock.authentication.exception.UserNotFoundException;
import com.cts.estock.authentication.model.User;
import com.cts.estock.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
         int userId = userRepository.getCount();
         user.setId(userId+1);
         userRepository.save(user);
         return user;
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserByEmailId(String emailId){
        User user = userRepository.findByEmailId(emailId);
        return user;
    }

    public User loadUserByEmailId(String emailId) throws UserNotFoundException {
        User checkUser = userRepository.findByEmailId(emailId);
//        if(checkUser == null) {
//            throw new UserNotFoundException("User Not Found");
//        }
        return checkUser;
    }
}
