package com.person.vincent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class SpringBootBasicApplication {

    @GetMapping("/")
    fun index() = "Hello Spring Boot!!!"
}

fun main(args: Array<String>) {
    runApplication<SpringBootBasicApplication>(*args)
}
