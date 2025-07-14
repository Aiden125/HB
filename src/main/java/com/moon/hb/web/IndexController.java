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

// 화면 안내용 컨트롤러
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(Model model, @LoginUser SessionUser user) {

        if (user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "posts-save-comparison";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    @GetMapping("/posts/list/comparison")
    public String comparison(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findComparisonDesc());

        if (user != null) {
            model.addAttribute("uName", user.getName());
        }

        return "posts-list-comparison";
    }

    @GetMapping("/posts/list/reviews")
    public String reviews(Model model) {

        model.addAttribute("posts", postsService.findReviewsDesc());

        return "posts-list-reviews";
    }

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
