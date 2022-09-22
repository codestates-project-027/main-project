package com.minimi.backend.community.contents.controller;

import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsDTO;
import com.minimi.backend.community.contents.mapper.ContentsMapper;
import com.minimi.backend.community.contents.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contents")
public class ContentsController {
    private final ContentsService contentsService;
    private final ContentsMapper contentsMapper;

    //post Content
    @PostMapping("")
    public ResponseEntity<ContentsDTO.response> postContents(@Valid @RequestBody ContentsDTO contentsDTO){
        contentsService.crateContents(contentsDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //patch Content
    @PatchMapping("/{contentsId}")
    public ResponseEntity patchContents(@PathVariable Long contentsId,
                                        @RequestBody ContentsDTO.patch contentsPatch){
        contentsService.patchContents(contentsPatch, contentsId);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //get Content
    @GetMapping("/{contentsId}")
    public ResponseEntity<ContentsDTO.response> getContents(@PathVariable Long contentsId){
        Contents contents = contentsService.findContents(contentsId);
        return new ResponseEntity(contents,HttpStatus.CREATED);
    }
    //get Contents
    @GetMapping("")
    public ResponseEntity<Slice<Contents>> getContentsList(@RequestParam int page){
        Slice<Contents> contentsSlice = contentsService.findContentsList(page-1, 3);
        List<Contents> contents = contentsSlice.getContent();
        return new ResponseEntity<>(contentsSlice,HttpStatus.OK);
    }
    //delete Content
    @DeleteMapping("/{contentsId}")
    public ResponseEntity deleteContents(@PathVariable Long contentsId){
        contentsService.deleteContents(contentsId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
