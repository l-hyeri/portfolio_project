package com.hyeri.portfolio.presentation.dto

import com.hyeri.portfolio.domain.entity.Link

class LinkDTO(
    val name: String,
    val content: String
) {
    constructor(link: Link) : this(
        name = link.name.lowercase(),  // 소문자로 바꿔서 값을 가져옴.
        content = link.content
    )
}