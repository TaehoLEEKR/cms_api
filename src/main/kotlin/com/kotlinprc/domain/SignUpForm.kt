package com.kotlinprc.domain

import java.time.LocalDate

class SignUpForm(
    val email: String,
    val name : String,
    val password: String,
    val birth: String,
    val phone: String
) {
}