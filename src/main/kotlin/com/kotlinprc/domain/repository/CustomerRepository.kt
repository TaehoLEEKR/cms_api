package com.kotlinprc.domain.repository

import com.kotlinprc.domain.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CustomerRepository : JpaRepository<Customer,Long> {
    fun findByEmail(email: String?): Optional<Customer>
}