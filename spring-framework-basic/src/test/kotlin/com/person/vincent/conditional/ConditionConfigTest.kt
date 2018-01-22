package com.person.vincent.conditional

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Author: vincent
 * Date: 2018-01-22 12:14:00
 * Comment:
 */
@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [ConditionConfig::class])
class ConditionConfigTest {

    @Test
    fun showListCmd() {
        val content = AnnotationConfigApplicationContext(ConditionConfig::class.java)
        val listService = content.getBean(ListService::class.java)
        if (content.environment.getProperty("os.name") == "Mac Os") {
            assert(listService.showListCmd() == "ls")
        }
        if (content.environment.getProperty("os.name") == "Windows") {
            assert(listService.showListCmd() == "dir")
        }
    }
}