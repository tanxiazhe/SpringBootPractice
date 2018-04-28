package com.archimedes.persistence;

import com.archimedes.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
