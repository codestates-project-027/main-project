package com.minimi.backend.member.domain;

import com.minimi.backend.community.likes.domain.Likes;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long memberId;
    @Column
    private String email; //id로 사용
    @Column
    private String username; //nickname으로 사용
    @Column
    private String password;
    @Column
    private String userProfile;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL)
    private List<Likes> likes;

}
