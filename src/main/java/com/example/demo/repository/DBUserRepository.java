package com.example.demo.repository;


import com.example.demo.entity.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBUserRepository extends JpaRepository<DBUser, Integer> {
    DBUser findByUsername(String username);
}