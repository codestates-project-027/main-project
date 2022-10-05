package com.minimi.backend.community.likes.domain;

import com.minimi.backend.member.domain.Member;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long likesId;
    @Column
    @NonNull
    private Long contentsId;
    @Column
    private String username;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;


}
