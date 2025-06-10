package com.kotlinprc.application

import com.kotlinprc.client.MailGunClient
import com.kotlinprc.domain.SignUpForm
import com.kotlinprc.domain.model.Customer
import com.kotlinprc.service.SignUpCustomerService
import org.springframework.stereotype.Service

@Service
class SignUpApplication (
    val mailGunClient: MailGunClient,
    val signUpCustomerService: SignUpCustomerService
){
    fun customerSignUp(signUpForm: SignUpForm) {
        if(signUpCustomerService.isEmailExist(signUpForm.email)){
            //Exception
        }else{
            var customer : Customer = signUpCustomerService.signUp(signUpForm)
        }
    }
}