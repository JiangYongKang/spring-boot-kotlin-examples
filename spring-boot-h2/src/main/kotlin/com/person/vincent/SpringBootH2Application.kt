package com.person.vincent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Author: vincent
 * Date: 2018-03-16 09:47:00
 * Comment:
 */

@SpringBootApplication
class SpringBootH2Application

fun main(args: Array<String>) {
    runApplication<SpringBootH2Application>(*args)
}