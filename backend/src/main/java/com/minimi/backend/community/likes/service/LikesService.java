package com.minimi.backend.community.likes.service;

import com.minimi.backend.exception.BusinessLogicException;
import com.minimi.backend.exception.ExceptionCode;
import com.minimi.backend.member.domain.Member;
import com.minimi.backend.member.domain.MemberRepository;
import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.community.likes.domain.Likes;
import com.minimi.backend.community.likes.domain.LikesDTO;
import com.minimi.backend.community.likes.domain.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;
    private final MemberRepository memberRepository;
    private final ContentsRepository contentsRepository;
    private Member member;

    public void createLikes(LikesDTO likesDTO) {
        if (findLikes(likesDTO).isPresent()) throw new BusinessLogicException(ExceptionCode.LIKE_EXISTS);

            Likes likes = Likes.builder()
                    .contentsId(likesDTO.getContentsId())
                    .username(likesDTO.getUsername())
                    .member(memberRepository.findByUsername(likesDTO.getUsername()))
                    .build();
            System.out.println(memberRepository.findByUsername(likesDTO.getUsername()));
            Contents contents = contentsRepository.findById(likes.getContentsId()).orElseThrow();
            contents.setLikes(contents.getLikes() + 1);
            likesRepository.save(likes);

    }
    public void deleteLikes(Long likesId){
        Likes likes = likesRepository.findById(likesId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.LIKE_NOT_FOUND));
        likesRepository.deleteById(likesId);
        Contents contents = contentsRepository.findById(likes.getContentsId()).orElseThrow();
        contents.setLikes(contents.getLikes()-1);
    }

    public Optional<Likes> findLikes(LikesDTO likesDTO){
        return likesRepository.findLikesByUsernameAndContentsId(likesDTO.getUsername(), likesDTO.getContentsId());
    }

}
