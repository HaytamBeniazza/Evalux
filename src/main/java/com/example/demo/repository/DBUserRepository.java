package com.example.demo.repository;

import com.example.demo.model.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DBUserRepository extends JpaRepository<DBUser, Long> {
     Optional<DBUser>  findByUsername(String username);
}
