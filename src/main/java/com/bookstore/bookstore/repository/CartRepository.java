package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.dto.CartDTO;
import com.bookstore.bookstore.model.BookModel;
import com.bookstore.bookstore.model.CartModel;
import com.bookstore.bookstore.model.UserRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartModel, Integer> {

}
