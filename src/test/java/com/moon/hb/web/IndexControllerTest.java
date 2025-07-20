package com.moon.hb.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 인덱스를 비롯한 화면들 API Test
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void 메인페이지_로딩() {
        // when
        String body = this.restTemplate.getForObject("/", String.class);

        // then
        Assertions.assertThat(body).contains("타이틀");
    }
//
//    @Test
//    public void 가격비교페이지_로딩() {
//        // when
//        String body = this.restTemplate.getForObject("/posts/list/comparison", String.class);
//
//        // then
//        Assertions.assertThat(body).contains("가격비교");
//    }
//
//    @Test
//    public void 교육원후기페이지_로딩() {
//        // when
//        String body = this.restTemplate.getForObject("/posts/list/reviews", String.class);
//
//        // then
//        Assertions.assertThat(body).contains("교육원후기");
//    }
//
//    @Test
//    public void 학점은행제소개페이지_로딩() {
//        // when
//        String body = this.restTemplate.getForObject("/posts/list/introduction", String.class);
//
//        // then
//        Assertions.assertThat(body).contains("소개");
//    }

}