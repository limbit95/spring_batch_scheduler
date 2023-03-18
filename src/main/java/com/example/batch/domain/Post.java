package com.example.batch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String title;
    private String contents;
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "authorId", referencedColumnName = "id")
    private Author author;

    @Setter
    private String scheduled;

    private LocalDateTime scheduledTime;

    @Builder
    public Post(String title, String contents, Author author, String scheduled, LocalDateTime scheduledTime){
        this.title = title;
        this.contents = contents;
        this.createDate = createDate.now();
        this.author = author;
        this.scheduled = scheduled;
        this.scheduledTime = scheduledTime;
    }


}
