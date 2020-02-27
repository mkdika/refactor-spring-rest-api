package com.github.mkdika.refactoringspringrestapi.controller

import com.github.mkdika.refactoringspringrestapi.model.Person
import com.github.mkdika.refactoringspringrestapi.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.Validator

@RestController
class PersonController {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var validator: Validator

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
    fun findAllPerson(): ResponseEntity<Iterable<Person>> {
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
    fun insertPerson(@Valid @RequestBody person: Person): ResponseEntity<Any> {
        return ResponseEntity.ok(personRepository.save(person))
    }
}