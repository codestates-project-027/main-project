package com.minimi.backend.community.contents.service;

import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsDTO;
//import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.community.contents.mapper.ContentsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
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
        Contents contents = findContents(contentsId);
        Optional.ofNullable(patch.getTitle())
                        .ifPresent(title -> contents.setTitle(title));
        Optional.ofNullable(patch.getContents())
                .ifPresent(content -> contents.setContents(content));

        return contentsRepository.save(contents);
    }
    public void deleteContents(Long contentsId){
        contentsRepository.delete(findContents(contentsId));
    }

    //---------------------------------------
    public Slice<Contents> findContentsList(int page,int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Slice<Contents> slice = contentsRepository.findSliceBy(pageRequest);
        return slice;
    }
//--------------------------------------------------
    public Contents findContents(Long contentsId){
        Optional<Contents> contents = contentsRepository.findById(contentsId);
        Contents findContents = contents.orElseThrow();
        return findContents;
    }
}
