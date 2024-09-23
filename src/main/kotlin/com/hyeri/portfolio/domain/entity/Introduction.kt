package com.hyeri.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction(
    var content: String,
    var isActive: Boolean,
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id")
    var id: Long? = null

}