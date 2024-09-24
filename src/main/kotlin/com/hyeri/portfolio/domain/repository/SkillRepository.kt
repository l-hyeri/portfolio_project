package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.constant.SkillType
import com.hyeri.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Skill>

    // select * from skill where name=: name and skill_type=: type
    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>
}