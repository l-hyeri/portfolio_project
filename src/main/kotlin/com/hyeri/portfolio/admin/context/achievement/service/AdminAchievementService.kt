package com.hyeri.portfolio.admin.context.achievement.service

import com.hyeri.portfolio.admin.context.achievement.form.AchievementForm
import com.hyeri.portfolio.admin.data.TableDTO
import com.hyeri.portfolio.domain.entity.Achievement
import com.hyeri.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    // 삽입, 수정 API 기능 구현
    @Transactional
    fun save(form: AchievementForm) {
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm) {
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }
}