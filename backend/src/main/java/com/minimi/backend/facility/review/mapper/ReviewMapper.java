package com.minimi.backend.facility.review.mapper;


import com.minimi.backend.facility.review.domain.Review;
import com.minimi.backend.facility.review.domain.ReviewDto;
import com.minimi.backend.facility.review.domain.ReviewFacilityMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    List<ReviewDto.response> reviewListToReviewDtoResList(List<Review> reviewList);
}
