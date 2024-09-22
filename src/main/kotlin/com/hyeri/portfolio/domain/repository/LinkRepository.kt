package com.hyeri.portfolio.domain.repository

import com.hyeri.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>