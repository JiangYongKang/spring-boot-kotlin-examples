package com.person.vincent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootConfiguringApplication

fun main(args: Array<String>) {
    runApplication<SpringBootConfiguringApplication>(*args)
}
