package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.AcmeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AcmeUser, Integer> {

    void deleteUserById(Integer id);
    Optional<AcmeUser> findUserById(Integer id);
    Optional<AcmeUser> findUserByEmail(String email);

}
