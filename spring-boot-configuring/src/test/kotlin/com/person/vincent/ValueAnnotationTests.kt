package com.person.vincent

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * Author: vincent
 * Date: 2018-02-09 17:10:00
 * Comment:
 * 通过 @Value 注解可以轻松的获取在默认配置文件中的配置项
 */

@SpringBootTest
@RunWith(SpringRunner::class)
class ValueAnnotationTests {

    @Value("\${server.servlet.context-path}")
    private lateinit var contentPath: String

    @Value("\${server.undertow.max-http-post-size}")
    private var maxHttpPostSize: Int? = null

    @Value("\${random.int}")
    private var number: Int? = null

    @Value("\${random.less}")
    private var lessNumber: String? = null

    @Value("\${random.uuid}")
    private var uuid: String? = null

    @Value("\${random.secret}")
    private var secret: String? = null

    @Test
    fun valueAnnotationTest() {
        Assert.assertNotNull(contentPath)
        Assert.assertEquals(maxHttpPostSize, 0)
        Assert.assertNotNull(number)
        Assert.assertNotNull(lessNumber)
        Assert.assertNotNull(uuid)
        Assert.assertNotNull(secret)

        Assert.assertEquals(contentPath, "/spring-boot-configuring")
    }
}