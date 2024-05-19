package com.moon.jakjumbank2.hakjumbank2.service.posts;

import com.moon.jakjumbank2.hakjumbank2.domain.posts.Posts;
import com.moon.jakjumbank2.hakjumbank2.domain.posts.PostsRepository;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsListResponseDto;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsResponseDto;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsSaveRequestDto;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * save는 repository를 통해 별도 쿼리를 날리지만 update의 경우 Id를 찾기만하고
     * 쿼리를 별도로 날리지 않는다. 별도로 쿼리를 날리지 않고, 영속성 컨텍스트를 가지고 있기에
     * 해당 인스턴스의 값을 변경하면 적용된다.
     * 즉, 데이터를 가져와서 해당값을 변경하면 디비도 알아서 업데이트된다.
     * @param id
     * @param requestDto
     * @return
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findComparisonDesc() {
        // 가격비교인거만 넣기
        return postsRepository.findComparisonDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findReviewsDesc() {
        // 가격비교인거만 넣기
        return postsRepository.findReviewsDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
