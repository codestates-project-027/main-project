package com.minimi.backend.community.comment.controller;

import com.minimi.backend.community.comment.domain.CommentDTO;
import com.minimi.backend.community.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    //post comment
    @PostMapping("")
    public ResponseEntity postComment(@RequestBody CommentDTO request){

        commentService.createComment(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //patch comment
    @PatchMapping("/{commentId}")
    public ResponseEntity patchComment(@PathVariable Long commentId,
                                       @RequestBody CommentDTO.patch patch){
        commentService.patchComment(commentId,patch);
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete comment
    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteComment(@PathVariable Long commentId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
