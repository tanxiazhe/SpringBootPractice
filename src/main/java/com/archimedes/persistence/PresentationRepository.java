package com.archimedes.persistence;


import com.archimedes.model.Presentation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Long> {
}




