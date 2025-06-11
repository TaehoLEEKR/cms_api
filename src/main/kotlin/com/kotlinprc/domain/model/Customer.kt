package com.kotlinprc.domain.model

import com.kotlinprc.domain.SignUpForm
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.envers.AuditOverride
import java.time.LocalDateTime

@Entity
@AuditOverride(forClass = BaseEntity::class)
class Customer : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    open var id: Long? = null

    @Column(unique = true)
    open var email: String? = null

    open var name: String? = null

    open var password: String? = null

    open var birth: String? = null

    open var phone: String? = null

    open var verifyExpiredAt : LocalDateTime? = null

    open var verificationCode : String? = null

    open var verify : Boolean? = null

    companion object {
        fun from(signUpForm: SignUpForm): Customer {
            return Customer().apply {
                email = signUpForm.email
                name = signUpForm.name
                password = signUpForm.password
                birth = signUpForm.birth
                phone = signUpForm.phone
                verify = false
            }
        }
    }

}