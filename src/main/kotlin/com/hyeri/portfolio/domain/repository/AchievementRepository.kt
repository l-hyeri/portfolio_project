package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long> {

    // select * from achievement where is_active=:isActive
    fun findAllByIsActive(isActive: Boolean): List<Achievement>

    // 결과가 단건일 경우
    //  fun findAllByIsActive(isActive: Boolean): Achievement
    //  fun findAllByIsActive(isActive: Boolean): Optional<Achievement>
}