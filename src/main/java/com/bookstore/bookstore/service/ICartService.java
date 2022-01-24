package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.CartDTO;
import com.bookstore.bookstore.model.CartModel;

public interface ICartService {

      CartModel addToCart(CartDTO cartDTO);
}
