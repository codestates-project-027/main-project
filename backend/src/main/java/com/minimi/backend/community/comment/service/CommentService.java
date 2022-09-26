package com.minimi.backend.community.comment.service;

import com.minimi.backend.community.comment.domain.Comment;
import com.minimi.backend.community.comment.domain.CommentDTO;
import com.minimi.backend.community.comment.domain.CommentRepository;
import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ContentsRepository contentsRepository;
    private final CommentRepository commentRepository;


    public void createComment(CommentDTO commentDTO){

        Contents contents = contentsRepository.findById(commentDTO.getContentsId()).orElseThrow();
        contents.setCommentNumber(contents.getCommentNumber()+1);
        commentRepository.save(new Comment(commentDTO.getContent(),commentDTO.getUsername(),contents));
    }
    public void patchComment(Long commentId, CommentDTO patch){
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if (patch.getContent()!=null){
            comment.setContent(patch.getContent());
        }
        commentRepository.save(comment);
//        Comment comment = commentRepository.findById(commentId).orElseThrow();
//        Optional.ofNullable(patch.getContent())
//                .ifPresent(contents -> comment.setContent(contents));
//        commentRepository.save(comment);
    }
    public void deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        commentRepository.deleteById(commentId);
        Contents contents = comment.getContents();
        contents.setCommentNumber(contents.getCommentNumber()-1);
    }

}
