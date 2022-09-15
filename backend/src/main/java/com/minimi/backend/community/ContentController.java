package com.minimi.backend.community;

import com.minimi.backend.auth.domain.AuthDTO;
import com.minimi.backend.community.domain.ContentDTO;
import com.minimi.backend.community.service.ContentService;
import com.minimi.backend.mypage.domain.DailyCheckDto;
import com.minimi.backend.mypage.service.DailyCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;
    //get Content
    //get Contents
    //post Content
    @PostMapping("")
    public ResponseEntity<ContentDTO.response> postContent(@RequestBody ContentDTO.request contentDtoRequest){
        return new ResponseEntity(contentService.createContent(contentDtoRequest),HttpStatus.CREATED);
    }
    //patch Content
    @PatchMapping("/{contentId}")
    public ResponseEntity patchFacility(@PathVariable Long contentId,
                                        @RequestBody ContentDTO.patch contentPatch){
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete Content
}
