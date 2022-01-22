package com.bookstore.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int bookId;
    private String bookDetails;
    private String authorName;
    private String bookName;
    private int price;
    private int noOfBooks;
    private String image;
    private int bookQuantity;
    private int bookRating;
}
