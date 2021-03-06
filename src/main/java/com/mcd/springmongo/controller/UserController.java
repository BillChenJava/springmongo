package com.mcd.springmongo.controller;

import com.mcd.springmongo.entity.User;
import com.mcd.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        System.out.println("123");
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getByUserId(@PathVariable String userId){
        return userRepository.findById(userId).orElse(new User());
    }

    @PostMapping(value = "")
    public User addNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping(value = "")
    public User update(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId){
        userRepository.deleteById(userId);
        return "delete:"+userId;
    }
}
