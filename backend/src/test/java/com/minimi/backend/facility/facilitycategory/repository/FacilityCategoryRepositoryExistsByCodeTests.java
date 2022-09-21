package com.minimi.backend.facility.facilitycategory.repository;

import com.minimi.backend.facility.facilitycategory.domain.FacilityCategory;
import com.minimi.backend.facility.facilitycategory.domain.FacilityCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("FacilityCategoryRepository Tests")
public class FacilityCategoryRepositoryExistsByCodeTests {

    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository;

    private FacilityCategory facilityCategory;

    @BeforeEach
    public void setup() {
        facilityCategory = FacilityCategory.builder()
                .categoryTitle("헬스")
                .categoryCode("220901")
                .build();
    }

    @Nested
    @DisplayName("FacilityCategoryRepository Case")
    public class successCase {

        @Test
        @DisplayName("Success FacilityCategoryRepository Test 1 -> exists")
        public void existsByCategoryCode() {
            facilityCategoryRepository.save(facilityCategory);

            String categoryCode = "220901";
            Boolean result = facilityCategoryRepository.existsByCategoryCode(categoryCode);

            assertThat(result, equalTo(true));
        }
    }

    @Nested
    @DisplayName("FacilityCategoryRepository Case")
    public class failCase {

        @Test
        @DisplayName("Fail FacilityCategoryRepository Test 1 -> notFound")
        public void existsByCategoryCode() {

            facilityCategoryRepository.save(facilityCategory);

            String categoryCode = "333333";
            Boolean result = facilityCategoryRepository.existsByCategoryCode(categoryCode);

            assertThat(result, equalTo(false));
        }
    }
}