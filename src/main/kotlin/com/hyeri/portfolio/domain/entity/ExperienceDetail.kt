package com.hyeri.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail(
    var content: String,
    var isActive: String
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id")
    var id: Long? = null

    fun update(content: String, isActive: String) {
        this.content = content
        this.isActive = isActive
    }
}