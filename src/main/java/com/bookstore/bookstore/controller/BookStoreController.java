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
@RequestMapping("/bookStore/book")
@Slf4j
public class BookStoreController {

    @Autowired
    private ModelMapper modelMapper;

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

    @PutMapping(value = "/updateBookDetails")
    public ResponseEntity<ResponseDTO> updateBookDetails(@RequestParam(name = "id") int id,
                                                         @RequestBody BookDTO bookDTO) {
        BookDTO updatedBookData = bookService.updateBook(id , bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated by ID : Book Details", updatedBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteBookDetails")
    public ResponseEntity<ResponseDTO> deleteBookDetails(@RequestParam(name = "id") int id) {
        bookService.deleteBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : Book Details", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @GetMapping(value = "/getBookDetailsByID")
    public ResponseEntity<ResponseDTO> getBookDetailsByID(@RequestParam(name = "id") int id) {
        log.info("getBookDetailsByID");
        log.info(String.valueOf(id));
        BookDTO bookDTO = bookService.getBookByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Fetched by ID : Book Details", bookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
