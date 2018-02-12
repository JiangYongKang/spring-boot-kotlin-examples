package cpm.person.vincent

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

/**
 * Author: vincent
 * Date: 2018-02-09 17:55:00
 * Comment:
 */

@SpringBootApplication
class SpringBootLoggerApplication {

    private val logger = LoggerFactory.getLogger(SpringBootLoggerApplication::class.java)

    @PostConstruct
    fun echo() {
        logger.info("info log")
        logger.warn("warn log")
        logger.error("error log")
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBootLoggerApplication>(*args)
}