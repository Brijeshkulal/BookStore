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
    private int cartId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity =BookModel.class)
    @JoinColumn(name = "cartId")
    private List<BookModel> booksList;

    private LocalDateTime createdTime;
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserRegistrationModel user;

    @OneToOne(mappedBy="cart",cascade = CascadeType.ALL)
    private Order order;
}