package com.person.vincent.schedule

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Author: vincent
 * Date: 2018-01-22 11:14:00
 * Comment:
 */

fun main(args: Array<String>) {
    AnnotationConfigApplicationContext(TaskSchedulerConfig::class.java)
}