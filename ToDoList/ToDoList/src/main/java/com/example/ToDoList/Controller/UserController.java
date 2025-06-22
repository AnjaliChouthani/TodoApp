package com.example.ToDoList.Controller;


import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.ToDoList.Services.UserServices;
import com.example.ToDoList.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping
    public String addUser(@RequestBody User user){
       return userServices.addUser(user);
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id){
     return  userServices.getUserById(id);
    }
}
