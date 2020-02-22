package com.github.mkdika.refactoringspringrestapi.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person (
        @Id
        val id: Int = -1,
        val firstName: String = "",
        val lastName: String = "",
        val email: String = ""
)