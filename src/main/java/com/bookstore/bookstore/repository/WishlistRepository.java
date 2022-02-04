package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    @Query(value = "select * from wishbook where id=?",nativeQuery = true)
    List<Wishlist> findBookById(int userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM wishbook WHERE book_id =? and id=?",nativeQuery = true)
    void deleteByBookIdandId(int bookId, int Id);

}