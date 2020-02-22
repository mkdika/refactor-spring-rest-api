package com.github.mkdika.refactoringspringrestapi.helper.test

import com.github.mkdika.refactoringspringrestapi.model.Person
import com.github.mkdika.refactoringspringrestapi.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DatabaseHelper {

    @Autowired
    lateinit var personRepository: PersonRepository

    fun clearAllPersons() {
        personRepository.deleteAll()
    }

    fun insertPerson(person: Person) {
        personRepository.save(person)
    }

}