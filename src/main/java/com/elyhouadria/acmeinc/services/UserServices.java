package com.elyhouadria.acmeinc.services;

import com.elyhouadria.acmeinc.entities.User;
import com.elyhouadria.acmeinc.exceptions.UserNotFoundException;
import com.elyhouadria.acmeinc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id: " + id + " was not found"));
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteUserById(id);
    }

}
