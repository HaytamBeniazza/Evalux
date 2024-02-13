package com.example.demo.repository;


import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID>{

    @Query("SELECT r From Reviews r where r.repoted=true")
    List<Review> findByReportedTrue();
}
