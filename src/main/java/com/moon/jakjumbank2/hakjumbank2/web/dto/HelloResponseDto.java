package com.moon.jakjumbank2.hakjumbank2.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // final 선언된 필드들을 생성자로 생성, final이 없으면 포함x
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
