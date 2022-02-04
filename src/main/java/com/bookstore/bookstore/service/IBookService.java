package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.model.BookModel;

import java.util.List;

public interface IBookService {
    List<BookDTO> getBook();
    BookDTO addBook(BookDTO bookDTO);
    BookDTO getBookByID(int id);
    List<BookModel> sortPriceLowToHigh();
    List<BookModel> sortPriceHighToLow();

}


