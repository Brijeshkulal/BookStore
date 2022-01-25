package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<BookModel> booksList;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Quantity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private List<Quantity> quantityOfBook;

    private LocalDateTime createdTime;
}