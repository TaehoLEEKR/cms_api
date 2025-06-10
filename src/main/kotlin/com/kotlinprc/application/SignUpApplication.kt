package com.kotlinprc.application

import com.kotlinprc.client.MailGunClient
import com.kotlinprc.service.SignUpCustomerService
import org.springframework.stereotype.Service

@Service
class SignUpApplication (
    val mailGunClient: MailGunClient,
    val signUpCustomerService: SignUpCustomerService
){
}