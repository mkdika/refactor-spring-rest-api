package com.github.mkdika.refactoringspringrestapi.controller

import com.github.mkdika.refactoringspringrestapi.model.Person
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PersonController {

    @GetMapping("/api/persons/{id}")
    fun findPersonById(@PathVariable(value = "id") id: Int): ResponseEntity<Person> {
        return ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
    }

    @GetMapping("/api/persons")
    fun findPerson(): ResponseEntity<Iterable<Person>> {
        return ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
    }

    @PostMapping("/api/persons")
    fun insertPerson(@RequestBody person: Person): ResponseEntity<Person> {
        return ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
    }
}