package com.minimi.backend.facility.review.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column
    private String username;

    @Column
    private String contents;

    @Column
    private LocalDateTime createdAt;

    @Builder
    public Review(String username, String contents){
        this.username = username;
        this.contents = contents;
        this.createdAt = LocalDateTime.now();
    }
}