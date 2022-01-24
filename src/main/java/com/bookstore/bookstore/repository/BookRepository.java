package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

}
