package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.CartDTO;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.model.CartModel;
import com.bookstore.bookstore.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addBookToCart(@RequestBody CartDTO cartDTO) {
        CartModel cart = cartService.addToCart(cartDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added item to cart", cart);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
