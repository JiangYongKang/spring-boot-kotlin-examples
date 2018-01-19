package com.person.vincent

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class QuickStartApplication {

    @GetMapping("/say")
    fun say(): String = "Hello World!!!"
}

fun main(args: Array<String>) {
    SpringApplication.run(QuickStartApplication::class.java, *args)
}
