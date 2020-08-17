package com.mcd.springmongo.controller;

import com.mcd.springmongo.entity.User;
import com.mcd.springmongo.repository.UserDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userTemplate")
public class UserTemplateController {

    @Autowired
    private final UserDAL userDAL;

    public UserTemplateController(UserDAL userDAL) {
        this.userDAL = userDAL;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userDAL.findAll();
    }

    @GetMapping("/{userId}")
    public User getByUserId(@PathVariable String userId){
        return userDAL.findById(userId);
    }

    @PostMapping("")
    public User addNewUser(@RequestBody User user){
        return userDAL.save(user);
    }

    @PutMapping("")
    public User update(@RequestBody User user){
        return userDAL.save(user);
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId){
        User user = new User();
        user.setUserId(userId);
        userDAL.deleteById(userId);
        return "deleted: "+userId;
    }
}
