package com.archimedes.persistence;

import com.archimedes.model.Presentation;
import com.archimedes.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.archimedes.model.Conference;
        import com.archimedes.model.Presentation;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
