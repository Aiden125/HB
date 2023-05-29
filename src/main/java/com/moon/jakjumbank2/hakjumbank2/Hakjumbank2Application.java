package com.moon.jakjumbank2.hakjumbank2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing 테스트 때문에 분리
@SpringBootApplication
public class Hakjumbank2Application {

    public static void main(String[] args) {
        SpringApplication.run(Hakjumbank2Application.class, args);
    }

}
