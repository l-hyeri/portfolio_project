package com.hyeri.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectDetail(
    var content: String,
    var url: String?,
    var isActive: String
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_detail_id")
    var id: Long? = null

    fun update(content: String, url: String?, isActive: String) {
        this.content = content
        this.url = url
        this.isActive = isActive
    }
}