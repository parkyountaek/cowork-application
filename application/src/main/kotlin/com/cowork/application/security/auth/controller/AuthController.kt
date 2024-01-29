package com.cowork.application.security.auth.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class AuthController {
    @PostMapping("/sign-up")
    fun signUp(): ResponseEntity<String> {
        return ResponseEntity.ok("hi")
    }

    @GetMapping
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("hello")
    }
}