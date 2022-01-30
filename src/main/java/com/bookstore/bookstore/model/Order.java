package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="order_table")
public class Order {
    @Id
    private int orderId;

    private LocalDateTime orderPlacedTime;

    private String orderStatus;

    private Double totalPrice;

    private int quantity;

    @OneToMany()
    @JoinColumn(name = "bookId")
    private List<BookModel> bookModel;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserRegistrationModel user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="orderId")
    private CartItem cart;
}
