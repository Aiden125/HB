package com.moon.jakjumbank2.hakjumbank2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hakjumbank2Application {

    public static void main(String[] args) {
        SpringApplication.run(Hakjumbank2Application.class, args);
    }

}
