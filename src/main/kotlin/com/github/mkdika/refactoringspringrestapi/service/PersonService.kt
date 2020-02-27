package com.github.mkdika.refactoringspringrestapi.service

import com.github.mkdika.refactoringspringrestapi.model.Person

interface PersonService {
    fun findById(id: Int): Person
    fun findAll(): List<Person>
    fun insert(person: Person): Person
}