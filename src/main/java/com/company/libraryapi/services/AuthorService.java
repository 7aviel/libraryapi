package com.company.libraryapi.services;

import com.company.libraryapi.persistence.entities.AuthorEntity;
import com.company.libraryapi.persistence.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void saveAuthor(AuthorEntity author){
        authorRepository.save(author);
    }

    public List<AuthorEntity> getAuthors(){
        return authorRepository.findAll();
    }

    public Optional<AuthorEntity> getAuthorById(long id){
        return authorRepository.findById(id);
    }

    public Optional<AuthorEntity> getByName(String name){
        return authorRepository.getByName(name);
    }

}
