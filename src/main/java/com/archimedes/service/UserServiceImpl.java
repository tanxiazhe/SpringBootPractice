package com.archimedes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archimedes.common.util.ExceptionHandlerUtils;
import com.archimedes.model.User;
import com.archimedes.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		ExceptionHandlerUtils.throwIfIdNotNull(user.getId());
		userRepository.save(user);
	}

	@Override
	public Optional<User> getUser(Long id) {
		ExceptionHandlerUtils.throwIfNonexisting(userRepository,id);
		return userRepository.findById(id);
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void updateUser(long id, User user) {
		ExceptionHandlerUtils.throwIfNonexisting(userRepository,id);
    	ExceptionHandlerUtils.throwIfInconsistent(id, user.getId());
		userRepository.save(user);
	}
}
