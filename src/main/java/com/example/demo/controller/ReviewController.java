package com.example.demo.controller;

import com.example.demo.entity.Review;
import com.example.demo.services.interfaces.ReviewService;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/addreview")
    public  String add(Model model){
        model.addAttribute("review" , new Review());
        return "add";
    }
    @GetMapping("/editreview/{id}")
    public  String edit(Model model, @PathVariable("id") UUID id){
        model.addAttribute("review", reviewService.getReviewById(id));
        return "edit";
    }

    @GetMapping("/deletereview/{id}")
    public  String delete(Model model){
        return "delete";
    }
}
