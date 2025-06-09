package com.kotlinprc.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.envers.AuditOverride

@Entity
@AuditOverride(forClass = BaseEntity::class)
class Customer : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    open var id: Long? = null

    open var email: String? = null

    open var name: String? = null

    open var password: String? = null

    open var birth: String? = null

    open var phone: String? = null
}