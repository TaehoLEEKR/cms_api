package com.kotlinprc.controller

import com.kotlinprc.application.SignUpApplication
import com.kotlinprc.domain.SignUpForm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-up")
class SignUpController(
    val signUpApplication: SignUpApplication
) {
    
    @PostMapping
    fun customerSignup(@RequestBody form: SignUpForm) : ResponseEntity<String> =
        ResponseEntity.ok(signUpApplication.customerSignUp(form))
    
}