package com.minimi.backend.facility.review.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_facility_id")
    private Long reviewFacilityId;

    @Column(unique = true, nullable = false)
    private Long facilityId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "review_list",
    joinColumns = @JoinColumn(name = "review_facility_id"),
    inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> review = new ArrayList<Review>();

    @Builder
    public ReviewFacility(Long facilityId){
        this.facilityId = facilityId;
    }

    public void addReview(Review review){
        this.review.add(review);
    }

    public void removeReview(Review review){
        this.review.remove(review);
    }
}
