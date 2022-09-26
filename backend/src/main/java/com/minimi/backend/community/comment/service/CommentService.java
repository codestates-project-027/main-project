package com.minimi.backend.community.comment.service;

import com.minimi.backend.community.comment.domain.Comment;
import com.minimi.backend.community.comment.domain.CommentDTO;
import com.minimi.backend.community.comment.domain.CommentRepository;
import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
