package com.hyeri.portfolio.presentation.interceptor

import com.hyeri.portfolio.domain.entity.HttpInterface
import com.hyeri.portfolio.domain.repository.HttpInterfaceRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.lang.Exception

@Component  // 스프링 빈 등록
class PresentationInterceptor(
    private val httpInterfaceRepository: HttpInterfaceRepository
) : HandlerInterceptor {
    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        val httpInterface=HttpInterface(request)
        httpInterfaceRepository.save(httpInterface)
    }
}