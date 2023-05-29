package com.moon.jakjumbank2.hakjumbank2.config.auth.dto;

import com.moon.jakjumbank2.hakjumbank2.domain.user.Role;
import com.moon.jakjumbank2.hakjumbank2.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    // OAuth2User 반환 값이 Map이기 때문에 이를 하나하나 변환해주어야함
    public static OAuthAttributes of(String registrationId, String userNameAttributesName, Map<String, Object> attributes) {

//        if ("naver".equals(registrationId)) {
//            return ofNaver("id", attributes);
//        }

        return ofGoogle(userNameAttributesName, attributes);
    }
    private static OAuthAttributes ofGoogle(String userNammAttributeName, Map<String, Object> attributes) {

        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNammAttributeName)
                .build();
    }

    // User 엔티티 생성
    // OAuthAttributes 에서 가입 시점에 엔티티 생성
    // 가입할 때 기본 권한으 GUEST
    // OAuthAttributes 클래스 생성 끝났으면 같은 패키지에 SessionUser 클래스 생성
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }

}
