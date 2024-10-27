package com.ensa.UserManagement.controller;

import com.ensa.UserManagement.model.User;
import com.ensa.UserManagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userservice ;

    public UserController(UserService userservice) {
        this.userservice = userservice;
    }
    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userservice.create(user) ;
    }
    @PutMapping("update/{id}")
    public User modifier(@PathVariable Long id , @RequestBody User user){
        return userservice.modifier(id,user) ;
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id  ){
        return userservice.delete(id );
    }
    @GetMapping
    public List<User> lire(){
        return userservice.lire() ;
    }

}
