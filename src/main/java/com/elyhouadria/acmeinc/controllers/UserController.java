package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.AcmeUser;
import com.elyhouadria.acmeinc.repositories.UserRepository;
import com.elyhouadria.acmeinc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AcmeUser>> getAllUsers() {
        List<AcmeUser> acmeUsers = userServices.findAllUsers();
        return new ResponseEntity<>(acmeUsers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AcmeUser> findUserById(@PathVariable("id") Integer id) {
        AcmeUser acmeUser = userServices.findAcmeUserById(id);
        return new ResponseEntity<>(acmeUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AcmeUser> addUser(@Valid
                                            @RequestBody AcmeUser acmeUser) {
        AcmeUser newAcmeUser = userServices.addUser(acmeUser);
        return new ResponseEntity<>(newAcmeUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AcmeUser> updateUser(@Valid
                                               @RequestBody AcmeUser acmeUser) {
        AcmeUser updateAcmeUser = userServices.updateUser(acmeUser);
        return new ResponseEntity<>(updateAcmeUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userServices.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
