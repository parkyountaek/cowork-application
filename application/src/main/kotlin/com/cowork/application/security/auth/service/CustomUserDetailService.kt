package com.cowork.application.security.auth.service

import com.cowork.application.security.auth.domain.CustomUserDetails
import com.cowork.application.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByEmail(username)?.let { CustomUserDetails.from(it) }
            ?: throw RuntimeException("NOT_FOUND")
    }
}