package com.example.demo.controller;


import com.example.demo.Services.ReviewService;
import com.example.demo.model.Review;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ReviewService reviewService;

    public AdminController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}/delete")
    public String deleteReview(@PathVariable UUID id) {
        reviewService.deleteReview(id);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateReview(@ModelAttribute Review review) {
        reviewService.updateReview(review);
        return "redirect:/";
    }

    @GetMapping("/reviewsReported")
    public String reviewsReported(Model model) {
        model.addAttribute("reviews",reviewService.reviewsReported());
        return "redirect:/";
    }
}
