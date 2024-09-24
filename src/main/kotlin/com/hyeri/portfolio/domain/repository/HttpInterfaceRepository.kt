package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {

    // 방문자 수 조회
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime): Long
    
}