package com.person.vincent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Author: vincent
 * Date: 2018-03-01 11:53:00
 * Comment:
 */

@SpringBootApplication
class SpringBootDatabaseApplication

fun main(args: Array<String>) {
    runApplication<SpringBootDatabaseApplication>(*args)
}