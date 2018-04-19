package com.archimedes.persistence;
import com.archimedes.model.Conference;
import com.archimedes.model.Presentation;
import com.archimedes.model.Tag;
import com.archimedes.model.BaseUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<BaseUser, Long> {
}
