package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>