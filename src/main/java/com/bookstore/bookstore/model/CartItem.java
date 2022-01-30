package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue
    private int cartId;

    @OneToOne()
    @JoinColumn(name = "bookId")
    private BookModel bookModel;

    @OneToOne()
    @JoinColumn(name = "Id")
    private UserRegistrationModel userRegistrationModel;

    private LocalDateTime createdTime;
}