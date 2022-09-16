package com.minimi.backend.mypage.domain;

import com.minimi.backend.auth.domain.Auth;
import com.minimi.backend.facility.domain.Bookmark;

import java.util.List;

public class MyFacility {
    private Long myFacilityId;
    private Auth user;
    private List<Bookmark> myfacility;
}
