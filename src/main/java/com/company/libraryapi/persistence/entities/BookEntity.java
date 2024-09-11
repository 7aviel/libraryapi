package com.company.libraryapi.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false,
            targetEntity = EditorialEntity.class
    )
    @JoinColumn(nullable = false)
    @JsonBackReference
    private EditorialEntity editorial;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false,
            targetEntity = AuthorEntity.class
    )
    @JoinColumn(nullable = false)
    @JsonBackReference
    private AuthorEntity author;


}
