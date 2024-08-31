package com.company.libraryapi.controller;

import com.company.libraryapi.persistence.entities.AuthorEntity;
import com.company.libraryapi.persistence.entities.BookEntity;
import com.company.libraryapi.persistence.entities.EditorialEntity;
import com.company.libraryapi.services.AuthorService;
import com.company.libraryapi.services.BookService;
import com.company.libraryapi.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private EditorialService editorialService;
    @Autowired
    private BookService bookService;


    @GetMapping("/home")

    public String helloWorld(){
        return "Hello world this is my API";
    }

    @PostMapping("/author")
    public String insertAuthor(@RequestBody AuthorEntity author){
        authorService.saveAuthor(author);
        return "author added successfully";
    }

    @PostMapping("/editorial")
    public String saveBook(@RequestBody EditorialEntity editorial){
        editorialService.saveEditorial(editorial);
        return "editorial added successfully";
    }

    @GetMapping("/author")
    public List<AuthorEntity> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/author/{id}")
    public Optional<AuthorEntity> getById(@PathVariable long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/book")
    public String insertBook(@RequestBody BookEntity bookEntity){
        bookService.saveBook(bookEntity);
        return "Book saved successfully";
    }

    @GetMapping("/books")
    public List<BookEntity> getBooks(){
        return bookService.getBooks();
    }


}
