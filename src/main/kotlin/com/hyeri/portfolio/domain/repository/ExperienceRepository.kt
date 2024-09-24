package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.Experience
import com.hyeri.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Experience>
}