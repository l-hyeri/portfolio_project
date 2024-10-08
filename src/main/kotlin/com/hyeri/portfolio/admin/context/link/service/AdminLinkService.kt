package com.hyeri.portfolio.admin.context.link.service

import com.hyeri.portfolio.admin.data.TableDTO
import com.hyeri.portfolio.domain.entity.Link
import com.hyeri.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {
    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}