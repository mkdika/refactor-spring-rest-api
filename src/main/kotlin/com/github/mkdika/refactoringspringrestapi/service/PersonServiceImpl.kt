package com.github.mkdika.refactoringspringrestapi.service

import com.github.mkdika.refactoringspringrestapi.model.Person
import com.github.mkdika.refactoringspringrestapi.repository.PersonRepository

class PersonServiceImpl(private val repository: PersonRepository) : PersonService {

    override fun findById(id: Int): Person {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Person> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insert(person: Person): Person {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}