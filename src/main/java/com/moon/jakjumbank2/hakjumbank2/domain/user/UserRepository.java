package com.moon.jakjumbank2.hakjumbank2.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // 첫 가입자 판단 용도
    Optional<User> findByEmail(String email);
}
