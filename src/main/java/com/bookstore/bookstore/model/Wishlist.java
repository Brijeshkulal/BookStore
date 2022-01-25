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
    private long wishlistId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<BookModel> booksList;


    private LocalDateTime wishlistTime;
}
