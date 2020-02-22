package com.github.mkdika.refactoringspringrestapi.repository

import com.github.mkdika.refactoringspringrestapi.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Int>