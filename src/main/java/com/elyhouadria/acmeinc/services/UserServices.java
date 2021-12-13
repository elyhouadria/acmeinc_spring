package com.elyhouadria.acmeinc.services;
import com.elyhouadria.acmeinc.entities.AcmeUser;
import com.elyhouadria.acmeinc.entities.common.UserConstant;
import com.elyhouadria.acmeinc.exceptions.UserNotFoundException;
import com.elyhouadria.acmeinc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AcmeUser addUser(AcmeUser acmeUser) {
        acmeUser.setCreationDate( new Date());
        acmeUser.setRoles(UserConstant.DEFAULT_ROLE);
        String encryptPassword = passwordEncoder.encode(acmeUser.getPassword());
        acmeUser.setPassword(encryptPassword);
        return userRepository.save(acmeUser);
    }

    public List<AcmeUser> findAllUsers() {
        return userRepository.findAll();
    }

    public AcmeUser updateUser(AcmeUser acmeUser) {
        System.out.println("user creation date spring update: " + acmeUser.getCreationDate());
        return userRepository.save(acmeUser);
    }

    public AcmeUser findAcmeUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User by id: " + email + " was not found"));
    }

    public AcmeUser findAcmeUserById(Integer id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id: " + id + " was not found"));
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteUserById(id);
    }
}
