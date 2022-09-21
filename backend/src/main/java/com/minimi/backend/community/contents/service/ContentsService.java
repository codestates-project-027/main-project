package com.minimi.backend.community.contents.service;

import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsDTO;
//import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.community.contents.mapper.ContentsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private  final ContentsRepository contentsRepository;
    private  final ContentsMapper contentsMapper;

    public void crateContents(ContentsDTO contentsDTO){
        Contents contents = contentsRepository.save(
                contentsMapper.contentsDTOToContents(contentsDTO));
    }
    public Contents patchContents(ContentsDTO.patch patch, Long contentsId){
        Contents contents = findVerifiedContents(contentsId);
        Optional.ofNullable(patch.getTitle())
                        .ifPresent(title -> contents.setTitle(title));
        Optional.ofNullable(patch.getContents())
                .ifPresent(content -> contents.setContents(content));

        return contentsRepository.save(contents);
    }
    public void deleteContents(ContentsDTO contentsDTO){

    }
    public ContentsDTO.response getContents(long contentsId) {
        return null;
    }
    public Slice<ContentsDTO.get> getContentsList(int page, int size){
        return null;
    }

    public Contents findVerifiedContents(Long contentsId){
        Optional<Contents> contents = contentsRepository.findById(contentsId);
        Contents findContents = contents.orElseThrow();
        return findContents;
    }
}
