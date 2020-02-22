package com.github.mkdika.refactoringspringrestapi.controller

import com.github.mkdika.refactoringspringrestapi.RefactoringSpringRestApiApplication
import com.github.mkdika.refactoringspringrestapi.helper.test.DatabaseHelper
import com.github.mkdika.refactoringspringrestapi.model.Person
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [RefactoringSpringRestApiApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = ["spring.profiles.active=test"])
class PersonControllerTest {

    @Autowired
    private lateinit var databaseHelper: DatabaseHelper

    @LocalServerPort
    private var port: Int = 0

    @AfterEach
    private fun tearDown() {
        databaseHelper.clearAllPersons()
    }

    @Test
    fun `given available id when request to findPersonById should return 200 with body`() {

        val userId = 1
        val dummyPerson = Person(
                id = userId,
                firstName = "Maikel",
                lastName = "Chandika",
                email = "mkdika@gmail.com"
        )
        databaseHelper.insertPerson(dummyPerson)

        Given {
            port(port)
        } When {
            get("/api/persons/$userId")
        } Then {
            statusCode(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(
                            "lastName", equalTo("Chandika"),
                            "firstName", equalTo("Maikel"),
                            "email", equalTo("mkdika@gmail.com")
                    )
        }
    }

    @Test
    fun `given unavailable id when request to findPersonById should return 404 without body`() {

        val notExistsUserId = 1

        Given {
            port(port)
        } When {
            get("/api/persons/$notExistsUserId")
        } Then {
            statusCode(HttpStatus.NOT_FOUND.value())
        } Extract {
            body().asString().equals(null)
        }
    }

    @Test
    fun `when data available and request to findPersons should return 200 with not empty array body`() {

        val dataSize = 3
        databaseHelper.generatePersonsData(dataSize)

        Given {
            port(port)
        } When {
            get("/api/persons")
        } Then {
            statusCode(HttpStatus.OK.value())
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body("size()", equalTo(dataSize))
        }
    }

    @Test
    fun `when data unavailable and request to findPersons should return 204 with empty body`() {

        Given {
            port(port)
        } When {
            get("/api/persons")
        } Then {
            statusCode(HttpStatus.NO_CONTENT.value())
        } Extract {
            body().asString().equals(null)
        }
    }

    @Test
    fun `given valid body when request to insertPerson should return 200 with body`() {
        throw NotImplementedError()
    }

    @Test
    fun `given invalid body when request to insertPerson should return 400 with error message body`() {
        throw NotImplementedError()
    }

    @Test
    fun `given unpresent mandatory fields body when request to insertPerson should return 400 with error message body`() {
        throw NotImplementedError()
    }

    @Test
    fun `given unavailable path when request should return 404`() {
        throw NotImplementedError()
    }

    class PersonList : List<Person> by ArrayList()
}