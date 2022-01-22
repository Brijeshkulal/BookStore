package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookDTO;

import java.util.List;

public interface IBookService {
    List<BookDTO> getBook();
    BookDTO addBook(BookDTO bookDTO);

}


