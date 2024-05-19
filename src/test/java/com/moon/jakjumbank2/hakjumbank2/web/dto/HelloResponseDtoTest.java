package com.moon.jakjumbank2.hakjumbank2.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

// Junit 기본 assertThat이 있고 assertj의 assertThat이 존재
// 기본 Junit은 CoreMatchers와 같은 라이브러리가 별도로 필요하고 자동완성이 약함
public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "문";
        int amount = 1;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }

}