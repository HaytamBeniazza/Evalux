package com.youcode.evalux.repositories;

import com.youcode.evalux.entities.DBUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<DBUser, Integer> {
    Optional<DBUser>  findByUsername(String username);
}
