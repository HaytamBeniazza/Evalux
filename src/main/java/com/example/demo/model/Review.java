package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name="Reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Boolean repoted;
}
