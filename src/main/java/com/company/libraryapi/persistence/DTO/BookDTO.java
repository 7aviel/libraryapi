package com.company.libraryapi.persistence.DTO;

import com.company.libraryapi.persistence.entities.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private boolean alta;
    private Integer year;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private String title;
    private String editorial;
    private String authorName;

    // Getters and setters

    public BookEntity toEntity() {
        BookEntity book = new BookEntity();
        book.setAlta(this.alta);
        book.setYear(this.year);
        book.setCopies(this.copies);
        book.setBorrowedCopies(this.borrowedCopies);
        book.setRemainingCopies(this.remainingCopies);
        book.setTitle(this.title);
        return book;
    }
}
