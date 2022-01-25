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
    private Long orderId;
    @Column(name = "order_placed_time")
    private LocalDateTime orderPlacedTime;



    private String orderStatus;

    private Double totalPrice;

    private Long addressId;


    @OneToMany
            (cascade = CascadeType.ALL, targetEntity = Quantity.class)
    @JoinColumn(name = "orderId")
    private List<Quantity> QuantityOfBooks;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<BookModel> BooksList;

    public Order() {
    }

    public Order(Long orderId, LocalDateTime orderPlacedTime, List<Quantity> quantityOfBooks,
                 List<BookModel> booksList) {
        super();
        this.orderId = orderId;
        this.orderPlacedTime = orderPlacedTime;
        QuantityOfBooks = quantityOfBooks;
        BooksList = booksList;
    }
}
