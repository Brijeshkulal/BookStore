package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.CartItem;

import java.util.List;

public interface ICartService {
    List<CartItem> addBooktoCart(String token, int bookId);

}
