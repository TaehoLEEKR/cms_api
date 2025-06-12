package com.kotlinprc.service

import com.kotlinprc.domain.SignUpForm
import com.kotlinprc.domain.model.Customer
import com.kotlinprc.domain.repository.CustomerRepository
import com.kotlinprc.exception.CustomException
import com.kotlinprc.exception.ErrorCode
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SignUpCustomerService (val customerRepository: CustomerRepository){

    fun signUp(form: SignUpForm) : Customer = customerRepository.save(Customer.from(form))

    fun isEmailExist(email : String) : Boolean = customerRepository.findByEmail(email).isPresent

    @Transactional
    fun ChangeCustomerValidateEmail(customerId : Long, verificationCode : String) : LocalDateTime?{
        val customer = customerRepository.findById(customerId);

        if(customer.isPresent){
            var customer : Customer = customer.get()
            customer.verificationCode = verificationCode
            customer.verifyExpiredAt = LocalDateTime.now().plusDays(1)
            return customer.verifyExpiredAt
        }
        throw CustomException(ErrorCode.NOT_FOUND_USER)
    }

    @Transactional
    fun verify(email : String, code : String) {
        val customer = customerRepository.findByEmail(email)
            .orElseThrow()
            {
                CustomException(ErrorCode.NOT_FOUND_USER)
            }

        if(customer.verify == true){
            throw CustomException(ErrorCode.ALREADY_VERIFY)
        }else if(customer.verificationCode != code){
            throw CustomException(ErrorCode.WRONG_VERIFICATION)
        }else if(customer.verifyExpiredAt!!.isBefore(LocalDateTime.now())){
            throw CustomException(ErrorCode.EXPIRE_CODE)
        }
        customer.verify = true
    }
}