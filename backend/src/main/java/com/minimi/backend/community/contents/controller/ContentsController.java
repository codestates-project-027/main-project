package com.minimi.backend.community.contents.controller;

import com.minimi.backend.community.contents.domain.ContentsDTO;
import com.minimi.backend.community.contents.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contents")
public class ContentsController {

    private final ContentsService contentsService;
    //get Content
    @GetMapping("/{contentsId}")
    public ResponseEntity<ContentsDTO.response> getContents(@PathVariable Long contentsId){
        return new ResponseEntity(contentsService.getContents(contentsId),HttpStatus.CREATED);
    }

    //get Contents
    @GetMapping("")
    public ResponseEntity<Slice<ContentsDTO.contents>> getContents(@RequestParam int page, @RequestParam int size){

        return new ResponseEntity<>(contentsService.getContentsList(page-1,size),HttpStatus.OK);
    }

    //post Content
    @PostMapping("")
    public ResponseEntity<ContentsDTO.response> postContents(@RequestBody ContentsDTO.request contentsDtoRequest){
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //patch Content
    @PatchMapping("/{contentsId}")
    public ResponseEntity patchContents(@PathVariable Long contentsId,
                                        @RequestBody ContentsDTO.patch contentsPatch){
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete Content
    @DeleteMapping("/{contentsId}")
    public ResponseEntity deleteContents(@PathVariable Long contentsId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
