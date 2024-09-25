package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.Experience
import com.hyeri.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.junit.jupiter.api.Test

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(
    @Autowired
    val experienceRepository: ExperienceRepository
) {

    val DATA_SIZE=10

    private fun createExperience(n: Int): Experience {
        val experience = Experience(
            title = "${n}",
            description = "테스트 설명 {n}",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )
        val details = mutableListOf<ExperienceDetail>()
        for (i in 1..n) {
            val experienceDetail = ExperienceDetail(content = "테스트 ${i}", isActive = true)
            details.add(experienceDetail)
        }
        experience.addDetails(details)
        return experience
    }

    // 테스트 데이터 초기화
    @BeforeAll
    fun beforeAll() {
        println("----- 데이터 초기화 이전 조회 시작 -----")
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0) // 위에 받은 데이터의 사이즈를 체크함.0이면 테스트를 통과함.
        println("----- 데이터 초기화 이전 조회 종료 -----")

        println("----- 테스트 데이터 초기화 시작 -----")
        val experiences = mutableListOf<Experience>()   // 리스트 생성
        for (i in 1..DATA_SIZE) {
            val experience = createExperience(i)    // i가 1이면 title이 1이고 details를 1개가지고 있는 experience가 생성됨.
            experiences.add(experience) // 생성된 experience가 생성한 리스트에 저장됨.
        }
        experienceRepository.saveAll(experiences)
        println("----- 테스트 데이터 초기화 종료 -----")
    }

    @Test
    fun testFindAll() {
        println("----- findAll 테스트 시작 -----")
        val experiences = experienceRepository.findAll()    // 위에서 저장된 expeirenc가 10가 저장되어 있음.
        assertThat(experiences).hasSize(DATA_SIZE)  // experience가 10개 있는지 검증

        println("experiences.size: ${experiences.size}")
        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())    // expeirence title만큰 detail을 가지고 있는지 검증
            println("experience.details.size: ${experience.details.size}")
        }
        println("----- findAll 테스트 종료 -----")
    }
    
    @Test
    fun testFindAllByIsActive() {
        println("----- findAllByIsActive 테스트 시작 -----")
        val experiences = experienceRepository.findAllByIsActive(true)  // isActive가 true인 것만 조회해옴.
//        val experiences = experienceRepository.findAllByIsActive(false)  // isActive가 true인 것만 조회해옴.
        assertThat(experiences).hasSize(DATA_SIZE)
        println("experiences.size: ${experiences.size}")
        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("experience.details.size: ${experience.details.size}")
        }
        println("----- findAllByIsActive 테스트 종료 -----")
    }
}