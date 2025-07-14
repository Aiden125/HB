package com.moon.hb.web.dto;

import com.moon.hb.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String category;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String category, String title, String content, String author) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .category(category)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
