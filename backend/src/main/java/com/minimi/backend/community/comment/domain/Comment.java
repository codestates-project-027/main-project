package com.minimi.backend.community.comment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.minimi.backend.community.contents.domain.Contents;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long commentId;
    @Column
    private String content;
    @Column
    private String username;
    @Column
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contentsId")
    private Contents contents;

    @Builder
    public Comment(String content, String username, Contents contents){
        this.content = content;
        this.username = username;
        this.contents = contents;
        this.createdAt = LocalDateTime.now();
    }

}
