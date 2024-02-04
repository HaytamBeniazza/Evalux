package com.example.demo.entity;

import com.example.demo.enums.Reaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name="Reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private DBUser user;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "claimes",
            joinColumns = @JoinColumn(name = "moderator_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private List<DBUser> claimedUser;
}