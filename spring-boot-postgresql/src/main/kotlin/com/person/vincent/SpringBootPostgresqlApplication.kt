package com.person.vincent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Author: vincent
 * Date: 2018-03-23 23:00:00
 * Comment:
 */

@SpringBootApplication
class SpringBootPostgresqlApplication

fun main(args: Array<String>) {
    runApplication<SpringBootPostgresqlApplication>(*args)
}