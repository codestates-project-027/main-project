package com.minimi.backend.community;

import com.minimi.backend.auth.domain.AuthDTO;
import com.minimi.backend.community.domain.Content;
import com.minimi.backend.community.domain.ContentDTO;
import com.minimi.backend.community.service.ContentService;
import com.minimi.backend.mypage.domain.DailyCheckDto;
import com.minimi.backend.mypage.service.DailyCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;
    //get Content
    @GetMapping("/{contentId}")
    public ResponseEntity<ContentDTO.response> getContent(@PathVariable Long contentId){
        return new ResponseEntity(contentService.getContent(contentId),HttpStatus.CREATED);
    }

    //get Contents
    @GetMapping("")
    public ResponseEntity<Slice<ContentDTO.contents>> getContents(@RequestParam int page, @RequestParam int size){

        return new ResponseEntity<>(contentService.getContents(page-1,size),HttpStatus.OK);
    }

    //post Content
    @PostMapping("")
    public ResponseEntity<ContentDTO.response> postContent(@RequestBody ContentDTO.request contentDtoRequest){
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //patch Content
    @PatchMapping("/{contentId}")
    public ResponseEntity patchContent(@PathVariable Long contentId,
                                        @RequestBody ContentDTO.request contentRequest){
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete Content
    @DeleteMapping("/{contentId}")
    public ResponseEntity deleteContent(@PathVariable Long contentId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
