package com.moon.jakjumbank2.hakjumbank2.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT p FROM Posts p WHERE p.category = '가격비교' ORDER BY p.id DESC")
    List<Posts> findComparisonDesc();

    @Query("SELECT p FROM Posts p WHERE p.category = '교육원후기' ORDER BY p.id DESC")
    List<Posts> findReviewsDesc();
}
