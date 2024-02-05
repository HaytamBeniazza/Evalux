package com.example.demo.controller;

import com.example.demo.entity.DBUser;
import com.example.demo.entity.Review;
import com.example.demo.repository.DBUserRepository;
import com.example.demo.services.interfaces.ReviewService;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ReviewController {

    private  final ReviewService  reviewService;
    private final DBUserRepository userRepository;
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

    @PostMapping("/addreview")
    public String addReview(@ModelAttribute Review review, Authentication authentication) {
        review.setDate(LocalDate.now());

        DBUser currentUser = userRepository.findByUsername(authentication.getName());
        review.setUser(currentUser);

        reviewService.saveReview(review);

        return "redirect:/reviews";
    }


    @GetMapping("/editreview/{id}")
    public  String edit(Model model, @PathVariable("id") UUID id){
        model.addAttribute("review", reviewService.getReviewById(id));
        return "edit";
    }


    @PostMapping("/editreview/{id}")
    public String editReview(@ModelAttribute @PathVariable("id") UUID id, Review review, Authentication authentication) {

        Review currentReview = reviewService.getReviewById(id);

        currentReview.setTitle(review.getTitle());
        currentReview.setMessage(review.getMessage());
        currentReview.setReaction(review.getReaction());
        reviewService.editReview(currentReview);

        return "redirect:/reviews";
    }

    @GetMapping("/deletereview/{id}")
    public  String delete(Model model){
        return "delete";
    }

    @PostMapping("/deletereview/{id}")
    public String deleteReview(@PathVariable("id") UUID id,Authentication authentication) {


        reviewService.deleteReview(id);

        return "redirect:/reviews";
    }
}
