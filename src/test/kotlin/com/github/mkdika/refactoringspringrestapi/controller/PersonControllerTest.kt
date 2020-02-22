package com.github.mkdika.refactoringspringrestapi.controller

import com.github.mkdika.refactoringspringrestapi.RefactoringSpringRestApiApplication
import com.github.mkdika.refactoringspringrestapi.model.Person
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [RefactoringSpringRestApiApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {

    @Test
    fun `given available id when request to findPersonById should return 200 with body`() {


    }

    @Test
    fun `given unavailable id when request to findPersonById should return 404`() {

    }

    @Test
    fun `when data available and request to findPersons should return 200 with body`() {

    }

    @Test
    fun `when data unavailable and request to findPersons should return 204 with empty body`() {

    }

    @Test
    fun `given valid body when request to insertPerson should return 200 with body`() {

    }

    @Test
    fun `given invalid body when request to insertPerson should return 400 with error message body`() {

    }

    @Test
    fun `given unpresent mandatory fields body when request to insertPerson should return 400 with error message body`() {

    }

    @Test
    fun `given unavailable path when request should return 404`() {

    }

    class PersonList : List<Person> by ArrayList()

}