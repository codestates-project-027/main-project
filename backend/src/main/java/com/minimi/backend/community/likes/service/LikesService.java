package com.minimi.backend.community.likes.service;

import com.minimi.backend.auth.domain.Auth;
import com.minimi.backend.auth.domain.MemberRepository;
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
    private Auth auth;

    public void createLikes(LikesDTO likesDTO){

        if(findLikes(likesDTO).isPresent()){

        }
        Likes likes = Likes.builder()
                .contentsId(likesDTO.getContentsId())
                .auth(memberRepository.findByUsername(likesDTO.getUsername()))
                .build();
        Contents contents = contentsRepository.findById(likes.getContentsId()).orElseThrow();
        contents.setLikes(contents.getLikes()+1);
        likesRepository.save(likes);
    }

    public Optional<Likes> findLikes(LikesDTO likesDTO){
        return likesRepository.findLikesByAuthAndContentsId(auth,likesDTO.getContentsId());
    }
}
