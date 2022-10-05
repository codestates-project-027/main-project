package com.minimi.backend.community.contents.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.minimi.backend.community.comment.domain.Comment;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long contentsId;
    @Column
    private String title;
    @Column
    private String contents;
    @Column
    private String username;
    @Column
    private String userProfile;
    @Column
    private int commentNumber;
    @Column
    private LocalDateTime createdAt;
    @Column
    private int views;

    @Column
    private int likes;
    @OneToMany(mappedBy = "contents", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();
    @Builder
    public Contents(String title, String contents, String username, String userProfile){
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.views = 0;
        this.userProfile = userProfile;
        this.createdAt = LocalDateTime.now();
    }
}
