package com.moon.hb.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Entity의 생성, 수정시간을 간편하게 추가해주는 슈퍼 엔티티
 * 원하는 곳에 상속시켜주어야하고 (Posts에 상속중)
 * Application쪽에 활성화를 명시해주어야 한다.(EnableJpaAuditing)
 */
@Getter
@MappedSuperclass // 엔티티가 아님을 명시
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity클래스에 Auditing 기능을 적용
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
