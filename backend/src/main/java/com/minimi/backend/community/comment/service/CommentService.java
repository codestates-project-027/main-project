package com.minimi.backend.community.comment.service;

import com.minimi.backend.community.comment.domain.Comment;
import com.minimi.backend.community.comment.domain.CommentDTO;
import com.minimi.backend.community.comment.domain.CommentRepository;
import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.exception.BusinessLogicException;
import com.minimi.backend.exception.ExceptionCode;
import com.minimi.backend.member.domain.Member;
import com.minimi.backend.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ContentsRepository contentsRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;


    public void createComment(CommentDTO commentDTO){
        checkName(commentDTO.getUsername());
        Contents contents = contentsRepository.findById(commentDTO.getContentsId()).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        contents.setCommentNumber(contents.getCommentNumber()+1);
        commentRepository.save(new Comment(commentDTO.getContent(),commentDTO.getUsername(),contents));
    }
    public void patchComment(Long commentId, CommentDTO patch){

        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        checkName(comment.getUsername());
        if (patch.getContent()!=null){
            comment.setContent(patch.getContent());
        }
        commentRepository.save(comment);
    }
    public void deleteComment(Long commentId){

        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
        checkName(comment.getUsername());
        commentRepository.deleteById(commentId);
        Contents contents = comment.getContents();
        contents.setCommentNumber(contents.getCommentNumber()-1);
    }
    public void checkName(String username){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = (String) authentication.getName();
        Optional<Member> member = memberRepository.findByEmail(name);
        String loginName=member.get().getUsername();
        if(!loginName.equals(username)) {
            throw new BusinessLogicException(ExceptionCode.NO_PERMISSIONS);
        }
    }

}
