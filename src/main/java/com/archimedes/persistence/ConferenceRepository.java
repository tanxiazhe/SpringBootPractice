package com.archimedes.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.archimedes.model.Conference;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {

}
