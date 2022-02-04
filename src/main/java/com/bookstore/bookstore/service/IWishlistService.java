package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.BookModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWishlistService {
    String addBooktoWishlist(String token, int bookId);

    List<BookModel> findBookList(String token);

   String deleteBookFromWishlist(String token, int bookId);

}
