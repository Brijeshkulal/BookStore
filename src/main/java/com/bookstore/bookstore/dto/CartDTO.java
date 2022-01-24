package com.bookstore.bookstore.dto;


import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.model.UserRegistrationModel;
import lombok.Data;

@Data
public class CartDTO {

    public  int id;
    public  int bookId;
//    public UserRegistrationModel user;
//    public BookModel book;
    public int quantity;
}
