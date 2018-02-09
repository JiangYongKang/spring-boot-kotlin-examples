package com.person.vincent

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

/**
 * Author: vincent
 * Date: 2018-02-09 15:41:00
 * Comment:
 */

@SpringBootTest
@RunWith(SpringRunner::class)
class EnvironmentTests {

    @Resource
    private lateinit var env: Environment

    @Test
    fun environmentTest() {
        assertNotNull(env.getProperty("JAVA_HOME"))
        assertNotNull(env.getProperty("server.servlet.context-path"))
        assertNotNull(env.getProperty("spring.thymeleaf.mode"))

        assertEquals(env.getProperty("JAVA_HOME"), "/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home")
        assertEquals(env.getProperty("server.servlet.context-path"), "/spring-boot-configuring")
        assertEquals(env.getProperty("spring.thymeleaf.mode"), "HTML")
    }
}

