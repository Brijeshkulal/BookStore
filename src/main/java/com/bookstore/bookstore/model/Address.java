package com.bookstore.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    private String pinCode;

    private String address;

    private String city;

    private String landmark;

    private String state;

    private String country;

}
