package com.moon.hb.domain.posts;

import com.moon.hb.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 크랠스 명시 카멜케이스를 스네이크 케이스로 테이블 매칭
public class Posts extends BaseTimeEntity {

    @Id // pk 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 적용
    private Long id;

    @Column(length = 500, columnDefinition = "TEXT")
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 생성자 대신 빌더 패턴을 활용
    public Posts(String category, String title, String content, String author) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
