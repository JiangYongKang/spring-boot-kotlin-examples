package com.person.vincent.profile

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Author: vincent
 * Date: 2018-01-22 14:21:00
 * Comment:
 */

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [ProfileConfig::class])
class ProfileConfigTest {

    @Test
    fun developmentBean() {
        val content = AnnotationConfigApplicationContext()
        content.environment.setActiveProfiles("development")
        content.register(ProfileConfig::class.java)
        content.refresh()
        val demoBean = content.getBean(DemoBean::class.java)
        assert(demoBean.content == "from development profile")
        content.close()
    }
}