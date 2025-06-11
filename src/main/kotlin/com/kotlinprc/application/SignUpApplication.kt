package com.kotlinprc.application

import com.kotlinprc.client.MailGunClient
import com.kotlinprc.client.SendMailForm
import com.kotlinprc.domain.SignUpForm
import com.kotlinprc.domain.model.Customer
import com.kotlinprc.exception.CustomException
import com.kotlinprc.exception.ErrorCode
import com.kotlinprc.service.SignUpCustomerService
import org.springframework.stereotype.Service
import org.apache.commons.lang3.RandomStringUtils
import java.time.LocalDateTime

@Service
class SignUpApplication (val mailGunClient: MailGunClient, val signUpCustomerService: SignUpCustomerService){

    fun customerSignUp(signUpForm: SignUpForm) : String {
        if(signUpCustomerService.isEmailExist(signUpForm.email)){
            //Exception
            throw CustomException(ErrorCode.ALREADY_REGISTER_USER)
        }else{
            val customer : Customer = signUpCustomerService.signUp(signUpForm)
            val now : LocalDateTime = LocalDateTime.now()
            val code : String = getRandomCode()
            val sendForm = SendMailForm(
                form = "test@test.com",
                to = signUpForm.email,
                subject = "Verification Test Email",
                text =
                    getVerificationEmailBody(
                        signUpForm.email,
                        signUpForm.name,
                        code
                    )
            )
            mailGunClient.sendEmail(sendForm)
            signUpCustomerService.ChangeCustomerValidateEmail(customer.id!!, code)
        }

        return "회원가입 완료"
    }

    fun getRandomCode() : String = RandomStringUtils.random(10,true,true)

    fun getVerificationEmailBody(email:String, name : String, code : String): String {
        var builder : StringBuilder = StringBuilder()
        return builder.append("Hello ").append(name).append("! Please Click Link for verification \n\n")
            .append("http://localhost:8080/customer/signup/verify?email=")
            .append(email)
            .append("&code=")
            .append(code).toString()
    }
}