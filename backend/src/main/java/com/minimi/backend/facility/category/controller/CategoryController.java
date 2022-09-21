package com.minimi.backend.facility.category.controller;


import com.minimi.backend.facility.category.domain.CategoryDto;
import com.minimi.backend.facility.category.service.CategoryService;
import com.minimi.backend.facility.dto.responsedto.ResponseFacilityDto;
import com.minimi.backend.facility.facility.domain.FacilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    //post category
    @PostMapping("")
    public ResponseEntity postCategory(@RequestBody @Valid CategoryDto.request categoryDtoRequest){
        categoryService.postCategory(categoryDtoRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //patch category
    @PatchMapping("/{categoryCode}")
    public ResponseEntity patchCategory(
            @PathVariable String categoryCode,
            @RequestBody @Valid CategoryDto.patch categoryDtoPatch){
        categoryService.patchCategory(categoryCode, categoryDtoPatch);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }


    //getall categorys
    @GetMapping("")
    public ResponseEntity<List<CategoryDto.response>> getCategoryTitles(){
        return new ResponseEntity<>(categoryService.getCategoryTitles(), HttpStatus.OK);
    }

    //get category
    @GetMapping("/{categoryCode}")
    public ResponseEntity<Slice<ResponseFacilityDto.facilityPageFromCategory>> getCategory(@PathVariable String categoryCode,
                                                                               @RequestParam int page){
        return new ResponseEntity<>(categoryService.getCategory(categoryCode, page), HttpStatus.OK);
    }
}