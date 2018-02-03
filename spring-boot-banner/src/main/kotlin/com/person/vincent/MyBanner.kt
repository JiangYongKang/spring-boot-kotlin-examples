package com.person.vincent

import org.springframework.boot.Banner
import org.springframework.core.env.Environment
import org.springframework.core.env.get
import java.io.PrintStream

/**
 * Author: vincent
 * Date: 2018-02-03 23:13:00
 * Comment: 代码层面去输出 banner
 */
class MyBanner : Banner {

    override fun printBanner(environment: Environment, sourceClass: Class<*>, out: PrintStream) {
        out.println("==============================================")
        out.println("Application Version: " + environment["APP_VERSION"])
        out.println("Application Name:    " + environment["APP_NAME"])
        out.println("Spring Boot version: " + environment["SPRING_BOOT_VERSION"])
        out.println("==============================================")
    }
}