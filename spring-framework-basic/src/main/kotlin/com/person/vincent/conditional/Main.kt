package com.person.vincent.conditional

import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Author: vincent
 * Date: 2018-01-22 11:38:00
 * Comment:
 */
fun main(args: Array<String>) {
    val content = AnnotationConfigApplicationContext(ConditionConfig::class.java)
    val listService = content.getBean(ListService::class.java)
    println("当前的操作系统是：" + content.environment.getProperty("os.name"))
    println("列出文件的命令是：" + listService.showListCmd())
}