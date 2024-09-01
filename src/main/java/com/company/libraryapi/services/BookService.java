package com.company.libraryapi.services;

import com.company.libraryapi.persistence.entities.AuthorEntity;
import com.company.libraryapi.persistence.entities.BookEntity;
import com.company.libraryapi.persistence.entities.EditorialEntity;
import com.company.libraryapi.persistence.repositories.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final EditorialService editorialService;
    private final AuthorService authorService;
    private final BookRepository bookRepository;

    @Transactional
    public void saveBook(BookEntity book, String authorName, String editorial){
        AuthorEntity author = authorService.getByName(authorName)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);
        EditorialEntity editorialEntity = editorialService.getByName(editorial).orElseThrow(()-> new RuntimeException("Editorial not found"));
        book.setEditorial(editorialEntity);
        bookRepository.save(book);
    }

    public List<BookEntity> getBooks(){
        return bookRepository.findAll();
    }

}
