package com.minimi.backend.facility.category.repository;


import com.minimi.backend.facility.category.domain.Category;
import com.minimi.backend.facility.category.domain.CategoryRepository;
import com.minimi.backend.facility.category.domain.CategoryStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("CategoryRepository Tests")
public class CategoryRepositoryExistsByCategoryCodeTests {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category category;

    @BeforeEach
    public void setup(){
        category = Category.builder()
                .categoryTitle("헬스")
                .categoryStatus(CategoryStatus.ACTIVE)
                .categoryCode("220901")
                .build();
    }

    @Nested
    @DisplayName("CategoryRepositorySuccess Case")
    public class successCategoryRepository {

        @Test
        @DisplayName("Success CategoryRepository Test 1 -> CategoryRepositoryExistsByCategoryCodeTests")
        public void existsByCategoryCode() {
            categoryRepository.save(category);

            String categoryCode = "220901";
            Boolean result = categoryRepository.existsByCategoryCode(categoryCode);

            assertThat(result, equalTo(true));
        }
    }

    @Nested
    @DisplayName("CategoryRepositoryFail Case")
    public class failCategoryRepository {

        @Test
        @DisplayName("Fail CategoryRepository Test 1 -> CategoryRepositoryExistsByCategoryCodeTests notFound")
        public void existsByCategoryCode() {

            categoryRepository.save(category);

            String categoryCode = "333333";
            Boolean result = categoryRepository.existsByCategoryCode(categoryCode);

            assertThat(result, equalTo(false));
        }
    }
}