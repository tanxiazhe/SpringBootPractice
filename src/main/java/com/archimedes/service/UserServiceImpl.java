package com.archimedes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archimedes.common.exception.NotFoundException;
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
    	Optional<User> existdUser = userRepository.findById(id);
    	user.setVersion(existdUser.get().getVersion());
    	
		userRepository.save(user);
	}

	@Override
	public void getUserByUserNameAndPassword( String userName, String password) {
		User existdUser = userRepository.findByUserName(userName); 
		if(existdUser ==null){
			NotFoundException notFoundException = new NotFoundException("request failed, userName  "+userName + " not found");
			throw notFoundException;
		}else if(!existdUser.getPassword().equals(password)){
			NotFoundException notFoundException = new NotFoundException("request failed, password is wrong.");
			throw notFoundException;
		}
	}
		
}
