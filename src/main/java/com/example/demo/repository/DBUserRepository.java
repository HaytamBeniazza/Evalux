package com.example.demo.repository;


import com.example.demo.entity.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DBUserRepository extends JpaRepository<DBUser, Long> {
    DBUser findByUsername(String username);

    Optional<DBUser> findById(Long id);
}