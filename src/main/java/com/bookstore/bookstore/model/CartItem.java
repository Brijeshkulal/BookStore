package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany()
    @JoinColumn(name = "bookId")
    private BookModel bookModel;

    @OneToOne()
    @JoinColumn(name = "Id")
    private UserRegistrationModel userRegistrationModel;

    private LocalDateTime createdTime;
}