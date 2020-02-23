package com.github.mkdika.refactoringspringrestapi.controller

import com.github.mkdika.refactoringspringrestapi.model.Person
import com.github.mkdika.refactoringspringrestapi.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PersonController {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @GetMapping(
            value = ["/api/persons/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findPersonById(@PathVariable(value = "id") id: Int): ResponseEntity<Person> {
        return personRepository.findById(id)
                .map { result ->
                    ResponseEntity.ok(result)
                }
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping(
            value = ["/api/persons"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findPerson(): ResponseEntity<Iterable<Person>> {
        val data = personRepository.findAll().toList()
        return if (data.isNotEmpty()) {
            ResponseEntity.ok(data)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @PostMapping(
            value = ["/api/persons"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertPerson(@RequestBody person: Person): ResponseEntity<Any> {
        val messages = mutableListOf<String>()

        if (person.firstName.isNotPresent()) {
            messages.add("firstName cannot null or empty or blank")
        }
        if (person.email.isNotPresent()) {
            messages.add("email cannot null or empty or blank")
        }

        if (messages.isEmpty()) {
            return ResponseEntity.ok(personRepository.save(person))
        } else {
            return ResponseEntity(ResponseError(messages = messages), HttpStatus.BAD_REQUEST)
        }
    }

    data class ResponseError(
            val messages: List<String> = emptyList()
    )

    fun String.isNotPresent(): Boolean {
        return this == null || this.isEmpty() || this.isBlank()
    }
}