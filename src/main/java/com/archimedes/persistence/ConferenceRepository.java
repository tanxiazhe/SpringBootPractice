package com.archimedes.persistence;



import com.archimedes.model.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {

}
