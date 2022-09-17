package com.minimi.backend.community;

import com.minimi.backend.community.domain.LikeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    //post like
    @PostMapping("")
    private ResponseEntity postLike(@RequestBody LikeDTO.request request) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //delete like
        @DeleteMapping("/{contentId}")
        private ResponseEntity deleteLike(@PathVariable Long contentId){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
