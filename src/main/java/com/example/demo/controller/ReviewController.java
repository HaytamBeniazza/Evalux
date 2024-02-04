package com.example.demo.controller;

import com.example.demo.services.interfaces.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@AllArgsConstructor
public class ReviewController {

    private  final ReviewService  reviewService;
    @GetMapping("/reviews")
    public String reviews(Model model, Authentication authentication) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        model.addAttribute("username", authentication.getName());
        model.addAttribute("role", authentication.getAuthorities().stream().findFirst().get().getAuthority());
        return "reviews";
    }
}
