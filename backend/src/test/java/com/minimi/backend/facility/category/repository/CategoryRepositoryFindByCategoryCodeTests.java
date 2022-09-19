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
public class CategoryRepositoryFindByCategoryCodeTests {

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
        @DisplayName("Success CategoryRepository Test 1 -> findByCategoryCode")
        public void findByCategoryCode() {
            categoryRepository.save(category);

            String categoryCode = "220901";
            Category result = categoryRepository.findByCategoryCode(categoryCode)
                    .orElseThrow(() -> new IllegalArgumentException("Category Not Found"));

            assertThat(result, equalTo(category));
        }
    }

    @Nested
    @DisplayName("CategoryRepositoryFail Case")
    public class failCategoryRepository {

        @Test
        @DisplayName("Fail CategoryRepository Test 1 -> findByCategoryCode notFound")
        public void findByCategoryCode() {

            String categoryCode = "220901";
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Category result = categoryRepository.findByCategoryCode(categoryCode)
                        .orElseThrow(() -> new IllegalArgumentException("Category Not Found"));
            });

            assertThat(exception.getMessage(), equalTo("Category Not Found"));
        }
    }
}