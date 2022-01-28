package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.AddressDTO;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.model.Address;
import com.bookstore.bookstore.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(value = "/addAddress/{token}")
    public ResponseEntity<ResponseDTO> addAddress(@RequestBody AddressDTO address, @PathVariable String token) {

        Address addressDetails = addressService.addAddress(address, token);

        if (addressDetails  != null) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDTO("added adress", addressDetails));
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDTO("not added", addressDetails));

        }
}
