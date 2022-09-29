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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
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
    //test용
    public ContentsDTO.response getContents(Long contentsId){
        return null;
    }

    public int updateViews(Long id) {
        return contentsRepository.updateViews(id);
    }
    /**
     조회수 중복 방지
     **/
    @Transactional
    public void viewCountUp(Long id, HttpServletRequest request, HttpServletResponse response) {
        Cookie oldCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("postView")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + id.toString() + "]")) {
                oldCookie.setValue(oldCookie.getValue() + "_[" + id + "]");
                oldCookie.setPath("/contents/{contentsId}");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
                updateViews(id);
            }
        } else {
            Cookie newCookie = new Cookie("postView","[" + id + "]");
            newCookie.setPath("/contents/{contentsId}");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
            updateViews(id);
        }
    }
}
