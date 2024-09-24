package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.Achievement
import com.hyeri.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Introduction>
}