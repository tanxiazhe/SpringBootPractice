package com.archimedes.persistence;
import com.archimedes.model.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserName(String userName);
}
