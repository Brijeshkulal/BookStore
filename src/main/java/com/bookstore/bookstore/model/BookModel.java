package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Book")
@Data
public class BookModel {

    @Id
    private int bookId;

    private String bookDetails;
    private String authorName;
    private String bookName;
    private int price;
    private int noOfBooks;

    @Column(name = "image")
    private String image;
}
