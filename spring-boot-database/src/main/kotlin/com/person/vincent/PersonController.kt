package com.person.vincent

import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Author: vincent
 * Date: 2018-03-01 16:17:00
 * Comment:
 */

@RestController
@RequestMapping("/person")
class PersonController(
        val repository: PersonRepository
) {

    @GetMapping
    fun index(): MutableIterable<Person>? = repository.findAll()

    @GetMapping("/{id}")
    fun edit(@PathVariable id: Long): Optional<Person> = repository.findById(id)

    @PostMapping
    fun create(@RequestBody person: Person): Person = repository.save(person)

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: Long) = repository.deleteById(id)
}