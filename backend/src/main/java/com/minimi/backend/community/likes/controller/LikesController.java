package com.minimi.backend.community.likes.controller;

import com.minimi.backend.community.likes.domain.LikesDTO;
import com.minimi.backend.community.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikesController {

    private final LikesService likesService;

    //post like
    @PostMapping("")
    private ResponseEntity postLikes(@RequestBody LikesDTO likesDTO) {
        likesService.createLikes(likesDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //delete like
        @DeleteMapping("/{contentId}")
        private ResponseEntity deleteLikes(@PathVariable Long likesId){
            likesService.deleteLikes(likesId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
