package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.AddressDTO;
import com.bookstore.bookstore.model.Address;

public interface IAddressService {
    Address addAddress(AddressDTO address, String token);
}
