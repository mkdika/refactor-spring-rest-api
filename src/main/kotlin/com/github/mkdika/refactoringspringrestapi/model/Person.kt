package com.github.mkdika.refactoringspringrestapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = -1,
        val firstName: String = "",
        val lastName: String = "",
        val email: String = ""
)