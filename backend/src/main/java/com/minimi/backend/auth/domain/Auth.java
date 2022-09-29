package com.minimi.backend.auth.domain;

import com.minimi.backend.community.likes.domain.Likes;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Auth {
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
    private String role;
    @OneToMany(
            mappedBy = "auth",
            cascade = CascadeType.ALL)
    private List<Likes> likes;
//    @Builder
//    public Auth(String email, String username, String password, String role){
//        this.email=email;
//        this.username=username;
//        this.password=password;
//        this.role=role;
//    }
}
