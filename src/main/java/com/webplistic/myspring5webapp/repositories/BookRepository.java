package com.webplistic.myspring5webapp.repositories;

import com.webplistic.myspring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
