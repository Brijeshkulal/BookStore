package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressModel,Integer> {
}
