package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    void deleteUserById(Integer id);
    Optional<User> findUserById(Integer id);

/*	int addUser(User user);
	void deleteUser(int userId);
	List<User> searchUsersByName(String searchString);
	User userAuthentication(String email, String password);
	void updateUser(User user);
	User getUserByEmailAndPassword(String email, String password);
	public List<User> getAllUsers();
	public User findUserById(int userId);*/
}