package com.moon.jakjumbank2.hakjumbank2.web;

import com.moon.jakjumbank2.hakjumbank2.config.auth.LoginUser;
import com.moon.jakjumbank2.hakjumbank2.config.auth.dto.SessionUser;
import com.moon.jakjumbank2.hakjumbank2.service.posts.PostsService;
import com.moon.jakjumbank2.hakjumbank2.web.dto.PostsResponseDto;
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
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
    @GetMapping("/posts/comparison")
    public String comparison(Model model) {

        model.addAttribute("posts", postsService.findComparisonDesc());

        return "posts-comparison";
    }

    @GetMapping("/posts/reviews")
    public String reviews(Model model) {

        model.addAttribute("posts", postsService.findReviewsDesc());

        return "posts-reviews";
    }

    @GetMapping("/posts/introduction")
    public String introduction(Model model) {

//        model.addAttribute("posts", postsService.findReviewsDesc());

        return "posts-introduction";
    }
}
