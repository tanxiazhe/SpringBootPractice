package com.archimedes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archimedes.common.exception.NotFoundException;
import com.archimedes.common.util.ExceptionHandlerUtils;
import com.archimedes.domain.User;
import com.archimedes.domain.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		ExceptionHandlerUtils.throwIfIdNotNull(user.getId());
		userRepository.save(user);
	}

	@Override public User getUserByEmail(String email) {
		ExceptionHandlerUtils.throwIfNonexistingEmail(userRepository,email);
		return userRepository.findByEmail(email);
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
    	Optional<User> existdUser = userRepository.findById(id);
    	user.setVersion(existdUser.get().getVersion());
    	
		userRepository.save(user);
	}

	@Override
	public void getUserByEmailAndPassword( String email, String password) {
		User existedUser = userRepository.findByEmail(email);
		if(existedUser ==null){
			NotFoundException notFoundException = new NotFoundException("request failed, email  "+ email + " not found");
			throw notFoundException;
		}else if(!existedUser.getPassword().equals(password)){
			NotFoundException notFoundException = new NotFoundException("request failed, password is wrong.");
			throw notFoundException;
		}
	}


		
}
