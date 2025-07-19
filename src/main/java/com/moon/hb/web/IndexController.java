package com.moon.hb.web;

import com.moon.hb.config.auth.LoginUser;
import com.moon.hb.config.auth.dto.SessionUser;
import com.moon.hb.service.posts.PostsService;
import com.moon.hb.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * view 페이지로 안내해주는 controller
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    // 메인 화면
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "index";
    }

    // 글 등록
    @GetMapping("/posts/save")
    public String postSave(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "posts-save-comparison";
    }

    // 글 수정
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    
    // 가격비교 페이지
    @GetMapping("/posts/list/comparison")
    public String comparison(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findComparisonDesc());

        if (user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "posts-list-comparison";
    }

    // 교육원 후기
    @GetMapping("/posts/list/reviews")
    public String reviews(Model model) {

        model.addAttribute("posts", postsService.findReviewsDesc());

        return "posts-list-reviews";
    }

    // 소개글
    @GetMapping("/posts/list/introduction")
    public String introduction(Model model) {

//        model.addAttribute("posts", postsService.findReviewsDesc());

        return "posts-list-introduction";
    }

    @GetMapping("/posts/view/{id}")
    public String postView(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-view-comparison";
    }
}
