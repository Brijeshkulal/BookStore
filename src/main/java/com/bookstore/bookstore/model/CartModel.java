package com.bookstore.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "BookCart")
@Data
public class CartModel {

    @Id
    @GeneratedValue
    private int cartId;

    private int quantity;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserRegistrationModel user;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private BookModel book;


    public CartModel() {
    }

    public CartModel(UserRegistrationModel user, BookModel  book, int quantity) {
        this.user = user;
        this.book = book;
        this.quantity = quantity;
    }

//    public CartModel(Optional<UserRegistrationModel> user, BookModel book, int quantity) {
//
//        this.user = getUser();
//        this.book = getBook();
//        this.quantity = book.getNoOfBooks();
//    }

}



