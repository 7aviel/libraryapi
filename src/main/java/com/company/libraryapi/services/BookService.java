package com.company.libraryapi.services;

import com.company.libraryapi.persistence.entities.BookEntity;
import com.company.libraryapi.persistence.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void saveBook(BookEntity book){
        bookRepository.save(book);
    }

    public List<BookEntity> getBooks(){
        return bookRepository.findAll();
    }

}
