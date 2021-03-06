package com.archimedes.service;

import java.util.List;
import java.util.Optional;

import com.archimedes.domain.User;

public interface UserService {
	Optional<User> getUser(Long id);

	List<User> getUsers();

	void updateUser(long id, User user);

	void addUser(User user);

	User getUserByEmail(String email);

    void getUserByEmailAndPassword(String userName, String password);


}
