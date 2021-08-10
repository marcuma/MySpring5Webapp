package com.webplistic.myspring5webapp.repositories;

import com.webplistic.myspring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
