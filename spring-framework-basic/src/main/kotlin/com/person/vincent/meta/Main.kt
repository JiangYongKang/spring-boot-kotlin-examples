package com.person.vincent.meta

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Author: vincent
 * Date: 2018-01-22 12:02:00
 * Comment:
 */
fun main(args: Array<String>) {
    val content = AnnotationConfigApplicationContext(MetaAnnotationConfig::class.java)
    val service = content.getBean(MetaAnnotationService::class.java)
    service.outputResult()
    content.close()
}