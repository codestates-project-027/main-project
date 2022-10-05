package com.minimi.backend.community.contents.service;

import com.minimi.backend.auth.userdetails.MemberDetailsService;
import com.minimi.backend.community.contents.domain.Contents;
import com.minimi.backend.community.contents.domain.ContentsDTO;
//import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.community.contents.domain.ContentsRepository;
import com.minimi.backend.community.contents.mapper.ContentsMapper;
import com.minimi.backend.exception.BusinessLogicException;
import com.minimi.backend.exception.ExceptionCode;
import com.minimi.backend.member.domain.Member;
import com.minimi.backend.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.prefs.BackingStoreException;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private  final ContentsRepository contentsRepository;
    private  final MemberRepository memberRepository;
    private  final ContentsMapper contentsMapper;

    public void crateContents(ContentsDTO contentsDTO){

        checkName(contentsDTO,getLoginName());
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
        Contents findContents = contents.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.CONTENTS_NOT_FOUND));
        return findContents;
    }
    //test용
    public ContentsDTO.response getContents(Long contentsId){
        return null;
    }

    public int updateViews(Long id) {
        return contentsRepository.updateViews(id);
    }

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
    public void checkName(ContentsDTO contentsDTO, String loginName){

    }
    public String getLoginName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getName();
        Optional<Member> member = memberRepository.findByEmail(username);

        return member.get().getUsername();
    }
}
