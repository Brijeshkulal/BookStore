package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.CartItem;
import com.bookstore.bookstore.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    @Query(value = "select * from wishbook where id=?",nativeQuery = true)
    List<Wishlist> findBookById(int userId);

}