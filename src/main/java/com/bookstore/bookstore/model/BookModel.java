package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Book")
@Data
public class BookModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bookId;

    private String bookDetails;
    private String authorName;
    private String bookName;
    private int price;
    private int noOfBooks;
    @Column(name = "image")
    private String image;
    private int discountPrice;
    private int bookRating;
    private int quantityInCart;


}
