package com.company.libraryapi.services;

import com.company.libraryapi.persistence.entities.BookEntity;
import com.company.libraryapi.persistence.entities.EditorialEntity;
import com.company.libraryapi.persistence.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    public void saveEditorial(EditorialEntity editorial){
        editorialRepository.save(editorial);
    }

    public Optional<EditorialEntity> getByName(String name){
        return editorialRepository.getByName(name);
    }

    public List<EditorialEntity> getEditorials(){
        return editorialRepository.findAll();
    }

}
