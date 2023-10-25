package com.cowork.application.user.domain

import jakarta.persistence.*

@Entity(name = "CO_USER")
class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "USER_ID") var userId: Long,
        @Column(name = "EMAIL", unique = true, nullable = false) var email: String,
        @Column(name = "PASSWORD", nullable = false) var password: String,
        @Column(name = "NAME", nullable = false) var name: String,
        @Column(name = "PHONE", nullable = false) var phone: String,
        @Column(name = "ROLES", nullable = false) var roles: String,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "COMPANY_ID") var company: Company
)