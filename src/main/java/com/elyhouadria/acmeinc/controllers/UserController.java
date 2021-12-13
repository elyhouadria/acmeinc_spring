package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.AcmeUser;
import com.elyhouadria.acmeinc.exceptions.UserNotFoundException;
import com.elyhouadria.acmeinc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

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
        System.out.println("creation date sent :" + acmeUser.getCreationDate());
        return new ResponseEntity<>(acmeUser, HttpStatus.OK);
    }

    @GetMapping("finduserbyemail/{email}")
    public ResponseEntity findUserByEmail(@PathVariable("email") String email) {
        try {
            AcmeUser acmeUser = userServices.findAcmeUserByEmail(email);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (UserNotFoundException ex) {}
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<AcmeUser> addUser(@Valid
                                            @RequestBody AcmeUser acmeUser) {
        System.out.println(acmeUser.getFirstName());
        System.out.println(acmeUser.getLastName());
        System.out.println(acmeUser.getEmail());
        System.out.println("psw:" + acmeUser.getPassword());
        AcmeUser newAcmeUser = userServices.addUser(acmeUser);
        return new ResponseEntity<>(newAcmeUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AcmeUser> updateUser(@Valid
                                               @RequestBody AcmeUser acmeUser) {
        System.out.println("Controller output: " + acmeUser.getCreationDate());
        AcmeUser updateAcmeUser = userServices.updateUser(acmeUser);
        return new ResponseEntity<>(updateAcmeUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userServices.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
