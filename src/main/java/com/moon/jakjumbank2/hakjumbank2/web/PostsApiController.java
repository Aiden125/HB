package com.moon.jakjumbank2.hakjumbank2.web;

import com.moon.jakjumbank2.hakjumbank2.domain.posts.PostsRepository;
import com.moon.jakjumbank2.hakjumbank2.service.posts.PostsService;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsSaveRequestDto;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long findById(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
