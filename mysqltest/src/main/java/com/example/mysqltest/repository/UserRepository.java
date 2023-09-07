package com.example.mysqltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysqltest.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}