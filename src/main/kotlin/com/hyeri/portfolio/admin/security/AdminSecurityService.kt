package com.hyeri.portfolio.admin.security

import com.hyeri.portfolio.admin.exception.AdminBadRequestException
import com.hyeri.portfolio.domain.repository.AccountRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AdminSecurityService(
    private val accountRepository: AccountRepository
) : UserDetailsService {

    override fun loadUserByUsername(loginId: String): UserDetails {
        return accountRepository.findByLoginId(loginId)
            .orElseThrow {
                throw AdminBadRequestException("사용자 정보를 찾을 수 없습니다.")
            }
    }
}