package com.hyeri.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @CreatedDate    // 생성 일시 (JPA Entity가 생성된 시간을 자동으로 세팅)
    @Column(nullable = false, updatable = false)
    // NULL 안됨, UPDATE 불가능 (이유 : Entity는 생성되고 나서 생성 일시가 수정되면 안됨.)
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate   // 마지막으로 수정된 일시
    @Column(nullable = false)
    var updatedDateTime: LocalDateTime = LocalDateTime.now()
}