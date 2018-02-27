package com.person.vincent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Author: vincent
 * Date: 2018-02-24 15:04:00
 * Comment:
 */

@SpringBootApplication
class SpringBootMvcApplication

fun main(args: Array<String>) {
    runApplication<SpringBootMvcApplication>(*args)
}