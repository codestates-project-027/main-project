package com.minimi.backend.facility;


import com.minimi.backend.facility.domain.Category;
import com.minimi.backend.facility.domain.CategoryDto;
import com.minimi.backend.facility.domain.Facility;
import com.minimi.backend.facility.domain.FacilityDto;
import com.minimi.backend.facility.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    //post category
    @PostMapping("")
    public ResponseEntity postCategory(@RequestBody CategoryDto.request categoryDtoRequest){

        return new ResponseEntity(HttpStatus.CREATED);
    }
    //patch category
    @PatchMapping("/{categoryTitle}")
    public ResponseEntity patchCategory(
            @PathVariable String categoryTitle,
            @RequestBody CategoryDto.request categoryDtoRequest){
        categoryService.patchCategory(categoryTitle, categoryDtoRequest);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }


    //getall categorys
    @GetMapping("")
    public ResponseEntity<List<CategoryDto.responseList>> getCategoryTitles(){
        return new ResponseEntity<>(categoryService.getCategoryTitles(), HttpStatus.OK);
    }

    //get category
    @GetMapping("/{categoryTitle}")
    public ResponseEntity<Slice<FacilityDto.responsePage>> getCategory(@PathVariable String categoryTitle,
                                                                       @RequestParam int page){
        return new ResponseEntity<>(categoryService.getCategory(categoryTitle, page), HttpStatus.OK);
    }
}