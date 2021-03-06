package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BookStoreController {


    @Autowired
    IBookService bookService;

    @PostMapping("/addBookDetails")
    public ResponseEntity<ResponseDTO> addBookDetails(@RequestBody BookDTO bookDTO) {
        BookDTO addData = bookService.addBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added newBook Details", addData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getBookDetails")
    public ResponseEntity<ResponseDTO> getBookDetails() {
        List<BookDTO> bookData = bookService.getBook();
        ResponseDTO responseDTO = new ResponseDTO("Fetched All Book Details", bookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/getBookDetailsByID/{id}")
    public ResponseEntity<ResponseDTO> getBookDetailsByID(@PathVariable int id) {
        BookDTO bookDTO = bookService.getBookByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Fetched by ID : Book Details", bookDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortByPriceAsc")
    public ResponseEntity<ResponseDTO> getBookByPriceAsc() {
        List<BookModel> bookData = bookService.sortPriceLowToHigh();
        ResponseDTO responseDTO = new ResponseDTO("Sorted all books by price low to high ", bookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/sortByPriceDsc")
    public ResponseEntity<ResponseDTO> getBookByPriceDsc() {
        List<BookModel> bookData = bookService.sortPriceHighToLow();
        ResponseDTO responseDTO = new ResponseDTO("Sorted all books by price high to low ", bookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
