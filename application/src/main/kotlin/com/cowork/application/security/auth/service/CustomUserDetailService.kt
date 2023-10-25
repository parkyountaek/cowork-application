package com.cowork.application.security.auth.service

import com.cowork.application.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
open class CustomUserDetailService(val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {

        TODO("Not yet implemented")
    }
}