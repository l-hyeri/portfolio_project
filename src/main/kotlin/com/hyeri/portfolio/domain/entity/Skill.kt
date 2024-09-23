package com.hyeri.portfolio.domain.entity

import com.hyeri.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    var name: String,
    type: String,
    var isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)

}