package com.company.libraryapi.persistence.repositories;

import com.company.libraryapi.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

}
