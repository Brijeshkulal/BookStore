package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="wishbook")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;

    private LocalDateTime createdTime;

    @OneToOne()
    @JoinColumn(name = "bookId")
    private BookModel bookModel;

    @OneToOne()
    @JoinColumn(name = "Id")
    private UserRegistrationModel userRegistrationModel;

}
