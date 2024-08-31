package com.company.libraryapi.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;
    private boolean alta;
    private Integer year;
    private Integer copies;
    private Integer borrowedCopies;
    private Integer remainingCopies;
    private String title;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false,
            targetEntity = EditorialEntity.class
    )
    @JoinColumn(nullable = false)
    private EditorialEntity editorial;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false,
            targetEntity = AuthorEntity.class
    )
    @JoinColumn(nullable = false)
    private AuthorEntity author;


}
