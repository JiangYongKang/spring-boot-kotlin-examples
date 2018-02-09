package com.person.vincent

import com.person.vincent.config.ThymeleafConfig
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import javax.annotation.Resource

/**
 * Author: vincent
 * Date: 2018-02-09 15:28:00
 * Comment:
 */
@SpringBootTest
@RunWith(SpringRunner::class)
class ThymeleafConfigTests {

    @Resource
    private lateinit var config: ThymeleafConfig

    @Test
    fun configTest() {
        assertNotNull(config.cache)
        assertNotNull(config.enabled)
        assertNotNull(config.mode)
        assertNotNull(config.prefix)
        assertNotNull(config.suffix)

        assertEquals(config.cache, true)
        assertEquals(config.enabled, true)
        assertEquals(config.mode, "HTML")
        assertEquals(config.prefix, "classpath:/templates/")
        assertEquals(config.suffix, ".html")
    }
}
