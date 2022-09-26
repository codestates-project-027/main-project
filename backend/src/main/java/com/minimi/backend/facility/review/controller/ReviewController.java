package com.minimi.backend.facility.review.controller;


import com.minimi.backend.facility.review.domain.ReviewDto;
import com.minimi.backend.facility.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    //getPage review
    @GetMapping("/{facilityId}")
    public ResponseEntity getReview(@PathVariable Long facilityId,
                                    @RequestParam int page) {
        return new ResponseEntity<>(reviewService.getReview(facilityId), HttpStatus.OK);
    }

    //post review
    @PostMapping("")
    public ResponseEntity postReview(@RequestBody ReviewDto.request reviewReq){
        reviewService.postReview(reviewReq);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //patch review
    @PatchMapping("/{reviewId}")
    public ResponseEntity patchReview(@PathVariable Long reviewId,
                                      @RequestBody ReviewDto.patch reviewPatch){
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }

    //delete review
    @DeleteMapping("/{facilityId}/{reviewId}")
    public ResponseEntity deleteReview(@PathVariable Long facilityId, Long reviewId) {
        reviewService.deleteReview(facilityId, reviewId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
