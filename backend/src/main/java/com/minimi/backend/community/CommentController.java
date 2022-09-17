package com.minimi.backend.community;

import com.minimi.backend.community.domain.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    //post comment
    @PostMapping("")
    public ResponseEntity postComment(@RequestBody CommentDTO.request request){
        return new ResponseEntity(request, HttpStatus.CREATED);
    }
    //patch comment
    @PatchMapping("/{commentId}")
    public ResponseEntity patchComment(@PathVariable Long commentId,
                                       @RequestBody CommentDTO commentDTO){
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete comment
    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long commentId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
