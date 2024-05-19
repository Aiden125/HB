package com.moon.jakjumbank2.hakjumbank2.web.dto;

import com.moon.jakjumbank2.hakjumbank2.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Response데이터의 경우 Entity에서 일부를 가져다쓰기 때문에
 * Entity 생성자를 파라미터로 받아서 가져다 쓴다.
 */
@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
