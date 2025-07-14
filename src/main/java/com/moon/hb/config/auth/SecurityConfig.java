package com.moon.hb.config.auth;

import com.moon.hb.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // h2-console 화면을 사용하기 위해 해당 옵션들 disable
                .csrf().disable()
                .headers().frameOptions().disable()

                // URL별 권한관리의 시작, 이게 있어야 antMatchers 사용 가능
                .and()
                .authorizeRequests()

                // 권한 관리 대상 옵션, URL, HTTP 메소드 별 관리 가능, permitAll() 옵션을 통해 전체 열람 권한 부여, /api/v1/** 주소를 가진 API는 USER권한을 가진 사람만 가능하도록
                .antMatchers("/", "/view/**", "/css/**", "/images/**",
                        "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())

                // 설정된 값들 이외 나머지 URL들을 나타냄, authenticated를 추가해 나머지 url들은
                // 인증된 사용자 즉, 로그인한 사용자에게만 허용한다는 것을 나타냄
                // api/v1쪽은 디비접근 옵션이므로 그쪽 남겨두고는 일단 퍼미션 허용하기
//                .anyRequest().authenticated()
                .anyRequest().permitAll()

                //로그아웃 기능에 대한 여러 설정 진입점, 로그아웃 성공시 '/'로 보냄
                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .oauth2Login() // oauth2의 진입점
                .userInfoEndpoint() // oauth2의 로그인 성공 이후 가져올 정보의 설정 담당
                .userService(customOAuth2UserService); // 로그인 성공 후 조치를 진행할 인터페이스 구현체 등록

    }
}
