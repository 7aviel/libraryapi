package com.company.libraryapi.persistence.repositories;

import com.company.libraryapi.persistence.entities.EditorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<EditorialEntity,Long> {
}
