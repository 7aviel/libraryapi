package com.company.libraryapi.persistence.repositories;

import com.company.libraryapi.persistence.entities.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorialRepository extends JpaRepository<EditorialEntity,Long> {

    @Query("SELECT e FROM EditorialEntity e WHERE e.name = :editorialName")
    Optional<EditorialEntity> getByName(@Param("editorialName") String editorialName);
}
