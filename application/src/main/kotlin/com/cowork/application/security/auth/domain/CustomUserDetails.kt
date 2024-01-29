package com.cowork.application.security.auth.domain

import com.cowork.application.user.domain.Role
import com.cowork.application.user.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class CustomUserDetails private constructor(
    private val userName: String,
    private val password: String,
    private val roles: MutableSet<Role>
) : UserDetails {

    companion object {
        fun from(user: User): CustomUserDetails {
            return with(user) {
                CustomUserDetails(name, password, roles)
            }
        }
    }
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles.stream().map { role -> SimpleGrantedAuthority("ROLE_$role") }
            .toList()
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return userName
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}