package com.example.demo.controller;


import com.example.demo.Services.ReviewService;
import com.example.demo.configuration.SpringSecurityConfig;
import com.example.demo.model.Review;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class LoginController {

    private final ReviewService reviewService;
    public LoginController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public String redirectToReviews(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if(isAdmin){
            List<Review> reviews = reviewService.reviewsReported();
            model.addAttribute("reviews", reviews);
            return "dashboard";
        }
        else{
            //return "allReviews";
            return "redirect:/reviews";
        }
    }
}

