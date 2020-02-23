package com.github.mkdika.refactoringspringrestapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@Entity
data class Person (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = -1,

        @field:NotEmpty(message = "First name must be presented")
        val firstName: String = "",

        val lastName: String = "",

        @field:NotEmpty(message = "Email must be presented")
        @field:Email(message = "Email should be valid")
        val email: String = ""
)