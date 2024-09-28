package com.hyeri.portfolio.presentation.dto

import com.hyeri.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}