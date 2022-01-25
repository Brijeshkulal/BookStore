package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long quantity_id;
    @Column
    private Long quantityOfBook;
    @Column
    private Double totalprice;
}
