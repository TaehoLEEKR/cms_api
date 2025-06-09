package com.kotlinprc.service

import com.kotlinprc.domain.SignUpForm
import com.kotlinprc.domain.model.Customer
import com.kotlinprc.domain.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class SignUpCustomerService (val customerRepository: CustomerRepository){
    fun signUp(form: SignUpForm) : Customer = customerRepository.save(Customer.from(form))
}