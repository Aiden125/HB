package com.moon.jakjumbank2.hakjumbank2.service.posts;

import com.moon.jakjumbank2.hakjumbank2.domain.posts.Posts;
import com.moon.jakjumbank2.hakjumbank2.domain.posts.PostsRepository;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsSaveRequestDto;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
}
