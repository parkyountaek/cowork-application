package com.cowork.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            formLogin { disable() }
            headers { frameOptions { disable() } }
            csrf { disable() }
            sessionManagement { SessionCreationPolicy.STATELESS }
            authorizeRequests {
                authorize("/auth/**", permitAll)
                authorize("/api/**", hasAnyAuthority("ROLE_USER", "ROLE_CORP_ADMIN", "ROLE_ADMIN"))
            }
        }

        return http.build()
    }
}