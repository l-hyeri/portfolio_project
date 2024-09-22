package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>