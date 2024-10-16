package com.hyeri.portfolio.domain

import com.hyeri.portfolio.domain.constant.SkillType
import com.hyeri.portfolio.domain.entity.*
import com.hyeri.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {

    val log: Logger = LoggerFactory.getLogger(DataInitializer::class.java)

    @PostConstruct
    fun initializeData() {
        log.info("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        // achievement 초기화
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "2024 동남권 SW 품질캠프 장려상",
                description = "‘자세분석’, ‘디디쌤’ SW제품(Web, App)에 대한 크라우드 테스팅 수행",
                host = "부산정보산업진흥원",
                achievedDate = LocalDate.of(2024, 7, 10),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2024, 6, 18),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        // introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "엔진처럼 안정적인 백엔드 개발자입니다.", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)


        // link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/l-hyeri", isActive = true),
            Link(name = "Chat-left-quote-fill", content = "https://velog.io/@gr_ace/posts", isActive = true),
        )
        linkRepository.saveAll(links)


        // experience 초기화
        val experience1 = Experience(
            title = "동의대학교(DongEui Univ.)",
            description = "컴퓨터소프트웨어공학과 전공",
            startYear = 2020,
            startMonth = 3,
            endYear = 2024,
            endMonth = 2,
            isActive = true,
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "3.78/4.5", isActive = true),
                ExperienceDetail(content = "학과 교육 봉사동아리 CPU 활동", isActive = true)
            )
        )

        val experience2 = Experience(
            title = "GDSC",
            description = "Google Developer Student Clubs",
            startYear = 2022,
            startMonth = 3,
            endYear = 2023,
            endMonth = 2,
            isActive = true,
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "스터디 진행", isActive = true),
                ExperienceDetail(content = "해커톤 참여", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))


        // skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val oracle = Skill(name = "Oracles", type = SkillType.DATABASE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, mysql, oracle))


        // project / project_detail / project_skill 초기화
        val project1 = Project(
            name = "웹 메일 유지보수 프로젝트",
            description = "기존 웹 메일 시스템의 효율성/안정성 개선",
            startYear = 2023,
            startMonth = 3,
            endYear = 2023,
            endMonth = 5, isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "교정, 완전화, 예방 유지 보수 수행", url = null, isActive = true),
                ProjectDetail(content = "정적 분석 도구 (Sonar Cloud)를 활용하여 코드의 품질을 분석하고 성능을 개선", url = null, isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql)
            )
        )
        val project2 = Project(
            name = "전자제품 렌탈 시스템",
            description = "전자제품 렌탈 시스템 개발(Spring 특성 활용)",
            startYear = 2024,
            startMonth = 5,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(
                    content = "JPA 사용", url = null, isActive = true
                ),
                ProjectDetail(
                    content = "Github Repository",
                    url = "https://github.com/l-hyeri/RentalTech",
                    isActive = true
                )
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = spring),
                ProjectSkill(project = project2, skill = mysql)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin1",
            pw = "\$2a\$10\$rYEo9MwK5ke.F0Zy5/B5jehohkXeNl4FUmwOTzNQFRhVMzzg3ukuu"
        )
        accountRepository.save(account)
    }
}