package com.moon.hb.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Dao 역할을 하는 인터페이스
 * 인터페이스를 만들고 Entity타입, PK타입을 상속받는것으로 설정
 * Repository랑 Entity는 매우 가까운 관계이므로 함께 두기
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT p FROM Posts p WHERE p.category = '가격비교' ORDER BY p.id DESC")
    List<Posts> findComparisonDesc();

    @Query("SELECT p FROM Posts p WHERE p.category = '후기' ORDER BY p.id DESC")
    List<Posts> findReviewsDesc();

    @Query("SELECT p FROM Posts p WHERE p.category = '제도소개' ORDER BY p.id DESC")
    List<Posts> findIntroductionDesc();
}
