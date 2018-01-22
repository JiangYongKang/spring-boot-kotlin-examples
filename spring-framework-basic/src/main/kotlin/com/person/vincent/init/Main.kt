package com.person.vincent.init

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Author: vincent
 * Date: 2018-01-22 14:05:00
 * Comment:
 */
fun main(args: Array<String>) {
    val content = AnnotationConfigApplicationContext(PrePostConfig::class.java)
    content.getBean(BeanWayService::class.java)
    content.getBean(AnnotationBeanService::class.java)
    content.close()
}