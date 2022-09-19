package com.minimi.backend.community.likes.controller;

import com.minimi.backend.community.likes.domain.LikesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikesController {

    //post like
    @PostMapping("")
    private ResponseEntity postLikes(@RequestBody LikesDTO.request request) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //delete like
        @DeleteMapping("/{contentId}")
        private ResponseEntity deleteLikes(@PathVariable Long contentId){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
