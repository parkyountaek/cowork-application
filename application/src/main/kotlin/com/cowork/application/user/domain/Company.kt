package com.cowork.application.user.domain

import jakarta.persistence.*

@Entity(name = "CO_COMPANY")
class Company(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "COMPANY_ID") var companyId: Long,
        @Column(name = "NAME", nullable = false) var name: String,
        @OneToMany(mappedBy = "company") var user: MutableSet<User>
)