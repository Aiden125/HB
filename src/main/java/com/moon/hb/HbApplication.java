package com.moon.hb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing 테스트 때문에 분리
@SpringBootApplication
public class HbApplication {

    public static void main(String[] args) {
        SpringApplication.run(HbApplication.class, args);
    }

}
