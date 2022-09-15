package com.minimi.backend.facility;


import com.minimi.backend.facility.domain.ReviewDto;
import com.minimi.backend.facility.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //delete review
}
