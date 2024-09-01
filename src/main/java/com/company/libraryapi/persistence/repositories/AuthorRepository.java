package com.company.libraryapi.persistence.repositories;

import com.company.libraryapi.persistence.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

    @Query("SELECT a FROM AuthorEntity a WHERE a.name = :authorName")
    Optional<AuthorEntity> getByName(@Param("authorName") String authorName);

    @Modifying
    @Query("UPDATE AuthorEntity a SET a.name = :authorName WHERE a.id = :id")
    void updateAuthorName(@Param("id") Long id,@Param("authorName") String authorName);
}
