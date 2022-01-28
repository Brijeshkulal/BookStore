package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
