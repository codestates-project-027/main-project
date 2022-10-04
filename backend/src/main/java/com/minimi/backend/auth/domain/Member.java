package com.minimi.backend.auth.domain;

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
    @Column
    private String roles;
    @OneToMany(
            mappedBy = "member",
            cascade = CascadeType.ALL)
    private List<Likes> likes;

    public List<String> getRoleList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
