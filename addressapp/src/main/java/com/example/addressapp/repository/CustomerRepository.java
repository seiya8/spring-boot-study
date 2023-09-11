package com.example.addressapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressapp.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByNameContainingOrderById(String keyword);
}
