package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.AddressDTO;
import com.bookstore.bookstore.model.Address;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.model.UserRegistrationModel;
import com.bookstore.bookstore.repository.AddressRepository;
import com.bookstore.bookstore.repository.UserRegistrationRepository;
import com.bookstore.bookstore.util.TokenUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService implements IAddressService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRegistrationRepository userRepository;

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public Address addAddress(AddressDTO address, String token) {
        int userId = TokenUtil.decodeToken(token);
        UserRegistrationModel user = userRepository.findById(userId).orElse(null);
        Address addressDetails = modelMapper.map(address,Address.class);
        user.getAddress().add(addressDetails);
        addressRepo.save(addressDetails);
        return addressDetails;
    }
}
