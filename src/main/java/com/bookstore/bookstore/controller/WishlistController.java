package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.service.IWishlistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@Slf4j
@CrossOrigin(origins = "",allowedHeaders = "")
public class WishlistController {

    @Autowired
    private IWishlistService wishlistService;

    @GetMapping("/addbookWishlist/{token}/{bookId}")
    public ResponseEntity<ResponseDTO> addBooktoWishlist(@PathVariable String token, @PathVariable int bookId) {
        String message = wishlistService.addBooktoWishlist(token,bookId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO("book added to wishlist", message));
    }

    @GetMapping("/GetBookList/{token}")
    public List<BookModel> getCartBookList(@PathVariable String token) {
        return wishlistService.findBookList(token);
    }

    @DeleteMapping("/deleteBookFromCart/{token}/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBookFromCart(@PathVariable String token,@PathVariable int bookId) {
        String message = wishlistService.deleteBookFromWishlist(token,bookId);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO("Book is deleted from wishlist", message));
    }

}
