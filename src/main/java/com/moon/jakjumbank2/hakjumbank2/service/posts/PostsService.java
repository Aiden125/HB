package com.moon.jakjumbank2.hakjumbank2.service.posts;

import com.moon.jakjumbank2.hakjumbank2.domain.posts.PostsRepository;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsSaveRequestDto;
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
}
