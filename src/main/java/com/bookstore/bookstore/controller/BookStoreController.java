package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.dto.ResponseDTO;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    BookService bookService;

    @PostMapping("/addBookDetails")
    public ResponseEntity<ResponseDTO> addBookDetails(@RequestBody BookDTO bookDTO) {
        BookDTO addData = bookService.addBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added newBook Details", addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getBookDetails")
    public ResponseEntity<ResponseDTO> getBookDetails() {
        List<BookDTO> bookData = bookService.getBook();
        ResponseDTO responseDTO = new ResponseDTO("Fetched All Book Details", bookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
