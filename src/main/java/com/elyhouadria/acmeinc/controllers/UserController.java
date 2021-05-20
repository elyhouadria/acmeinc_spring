package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.User;
import com.elyhouadria.acmeinc.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices){this.userServices=userServices;}

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServices.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id){
        User user = userServices.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        user.setCreationDate(new Date());
        User newUser = userServices.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser = userServices.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userServices.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
