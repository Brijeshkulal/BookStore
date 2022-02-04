package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.AddressDTO;
import com.bookstore.bookstore.model.AddressModel;
import com.bookstore.bookstore.model.UserRegistrationModel;
import com.bookstore.bookstore.repository.AddressRepository;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import com.bookstore.bookstore.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService implements IAddressService{

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRegistrationRepository userRepository;

    @Autowired
    BookRepository bookStoreRepository;


    @Override
    public AddressModel addAddress(AddressDTO address, String token) {
        int userId = TokenUtil.decodeToken(token);
        UserRegistrationModel user = userRepository.findById(userId).orElse(null);
        AddressModel addressDetails=new AddressModel();
        addressDetails.setAddress(address.getAddress());
        addressDetails.setCity(address.getCity());
        addressDetails.setState(address.getState());
        addressDetails.setUserRegistrationModel(user);
        return addressRepository.save(addressDetails);
    }
}
