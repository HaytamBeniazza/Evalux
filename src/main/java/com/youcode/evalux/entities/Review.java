package com.youcode.evalux.entities;

import com.youcode.evalux.enums.Reaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name="Reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    private String Title;
    private String message;
    @Enumerated(EnumType.STRING)
    private Reaction reaction;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer")
    private User user;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "claimes",
        joinColumns = @JoinColumn(name = "moderator_id"),
        inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private List<User> claimedUser;
}