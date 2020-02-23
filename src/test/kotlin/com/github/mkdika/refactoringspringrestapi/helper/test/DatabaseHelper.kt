package com.github.mkdika.refactoringspringrestapi.helper.test

import com.github.javafaker.Faker
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

    fun insertPerson(person: Person): Person {
        return personRepository.save(person)
    }

    fun generatePersonsData(size: Int) {
        val faker = Faker()
        (1..size).forEach {
            val p = Person(
                    firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    email = faker.internet().emailAddress()
            )
            personRepository.save(p)
        }
    }

    fun getAllPersons(): List<Person> {
        return personRepository.findAll().toList()
    }
}