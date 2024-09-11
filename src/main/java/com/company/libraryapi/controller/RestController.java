package com.company.libraryapi.controller;

import com.company.libraryapi.persistence.DTO.BookDTO;
import com.company.libraryapi.persistence.entities.AuthorEntity;
import com.company.libraryapi.persistence.entities.EditorialEntity;
import com.company.libraryapi.services.AuthorService;
import com.company.libraryapi.services.BookService;
import com.company.libraryapi.services.EditorialService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/editorials")
    public String saveBook(@RequestBody EditorialEntity editorial){
        editorialService.saveEditorial(editorial);
        return "editorial added successfully";
    }
    @GetMapping("/editorials")
    public List<EditorialEntity> getEditorials(){
        return editorialService.getEditorials();
    }

    @GetMapping("/authors")
    public List<AuthorEntity> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{id}")
    public Optional<AuthorEntity> getById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> insertBook(@RequestParam("alta") boolean alta,
                                           @RequestParam("year") Integer year,
                                           @RequestParam("copies") Integer copies,
                                           @RequestParam("borrowedCopies") Integer borrowedCopies,
                                           @RequestParam("remainingCopies") Integer remainingCopies,
                                           @RequestParam("title") String title,
                                           @RequestParam("authorName") String authorName,
                                           @RequestParam("editorial") String editorial,
                                           @NotNull @RequestParam("image")MultipartFile image) throws IOException {
        BookDTO bookDTO = BookDTO.builder()
                .alta(alta)
                .year(year)
                .copies(copies)
                .borrowedCopies(borrowedCopies)
                .remainingCopies(remainingCopies)
                .title(title)
                .authorName(authorName)
                .editorial(editorial)
                .image(image.getBytes())
                .build();
        bookService.saveBook(bookDTO.toEntity(), bookDTO.getAuthorName(),bookDTO.getEditorial());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/books")
    public List<BookDTO> getBooks(){
        return bookService.getBookData();
    }

    @PatchMapping("/authors/{id}/{authorName}")
    public ResponseEntity<Void> updateAuthorName(@PathVariable Long id,@PathVariable String authorName){
        authorService.updateAuthor(id,authorName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
