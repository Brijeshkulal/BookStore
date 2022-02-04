package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.AddressDTO;
import com.bookstore.bookstore.model.AddressModel;

public interface IAddressService {

    AddressModel addAddress(AddressDTO address, String token);
}
