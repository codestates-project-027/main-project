package com.minimi.backend.community.likes.domain;

import com.minimi.backend.auth.domain.Auth;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Auth auth;


}
