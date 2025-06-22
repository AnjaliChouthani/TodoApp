package com.example.ToDoList.Services;

import com.example.ToDoList.Repository.UserRepository;
import com.example.ToDoList.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    public String addUser(User user) {
        if(userRepository.existsByName(user.getName())){
            return "already exist "+user.getName()+".";
        }
        else{
            userRepository.save(user);
            return "added sucessfully";
        }
    }
    public Optional<User> getUserById(Long id) {
      return userRepository.findById(id);



    }
    //get user
}

