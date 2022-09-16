package com.minimi.backend.community;

import com.minimi.backend.community.domain.CommentDTO;
import com.minimi.backend.community.service.CommentService;
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
    public ResponseEntity postComment(@RequestBody CommentDTO.request request){
        return new ResponseEntity(request, HttpStatus.CREATED);
    }
    //patch comment
    @PatchMapping("/{commentId}")
    public ResponseEntity patchComment(@PathVariable String commentId,
                                      @RequestBody CommentDTO.patch patch){
        return new ResponseEntity(HttpStatus.RESET_CONTENT);
    }
    //delete comment
    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteComment(@PathVariable String commentId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
