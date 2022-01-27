package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.model.CartItem;
import com.bookstore.bookstore.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CartServiceController {

    @Autowired
    private ICartService cartService;

    @GetMapping("/addbookCart/{token}/{bookId}")
    public ResponseEntity<ResponseDTO> addBooksToCart(@PathVariable String token, @PathVariable int bookId) {
        List<CartItem> cartItem = cartService.addBooktoCart(token,bookId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO("book added to cart", cartItem));
    }
}
