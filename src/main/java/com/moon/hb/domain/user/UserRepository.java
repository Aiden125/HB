package com.moon.hb.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Dao 역할을 하는 인터페이스
 * 인터페이스를 만들고 Entity타입, PK타입을 상속받는것으로 설정
 * Repository랑 Entity는 매우 가까운 관계이므로 함께 두기
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    // 첫 가입자 판단 용도
    Optional<User> findByEmail(String email);
}
