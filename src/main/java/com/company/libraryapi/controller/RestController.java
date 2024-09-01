package com.company.libraryapi.controller;

import com.company.libraryapi.persistence.DTO.BookDTO;
import com.company.libraryapi.persistence.entities.AuthorEntity;
import com.company.libraryapi.persistence.entities.EditorialEntity;
import com.company.libraryapi.services.AuthorService;
import com.company.libraryapi.services.BookService;
import com.company.libraryapi.services.EditorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestController {


    private AuthorService authorService;
    private EditorialService editorialService;
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
    @GetMapping("/editorial")
    public List<EditorialEntity> getEditorials(){
        return editorialService.getEditorials();
    }

    @GetMapping("/author")
    public List<AuthorEntity> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/author/{id}")
    public Optional<AuthorEntity> getById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/book")
    public String insertBook(@RequestBody BookDTO bookDTO){
        bookService.saveBook(bookDTO.toEntity(), bookDTO.getAuthorName(),bookDTO.getEditorial());
        return "Book saved successfully";
    }

    @GetMapping("/books")
    public List<BookDTO> getBooks(){
        return bookService.getBookData();
    }

    @PutMapping("/author/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long id,@RequestParam String authorName){
        authorService.updateAuthor(id,authorName);
        return ResponseEntity.ok().build();
    }


}
