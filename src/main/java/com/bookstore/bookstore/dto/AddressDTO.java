package com.bookstore.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String pinCode;

    private String address;

    private String city;

    private String landmark;

    private String state;

    private String country;
}
