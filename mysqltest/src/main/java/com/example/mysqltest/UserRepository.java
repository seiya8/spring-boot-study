package com.example.mysqltest;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mysqltest.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}