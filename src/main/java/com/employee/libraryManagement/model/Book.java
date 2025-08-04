package com.employee.libraryManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    private int id;
    private String bookName;
    private String bookAuthor;
    private String bookISBN;

}
