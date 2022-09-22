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

    //post review
    @PostMapping("")
    public ResponseEntity postReview(@RequestBody ReviewDto.request reviewReq){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //patch review
    @PatchMapping("/{reviewId}")
    public ResponseEntity patchReview(@PathVariable String reviewId,
                                      @RequestBody ReviewDto.patch reviewPatch){
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }

    //delete review
    @DeleteMapping("/{reviewId}")
    public ResponseEntity deleteReview(@PathVariable String reviewId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
