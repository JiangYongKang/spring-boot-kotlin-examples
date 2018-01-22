package com.person.vincent.async

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val content = AnnotationConfigApplicationContext(TaskExecutorConfig::class.java)
    val asyncTaskService = content.getBean(AsyncTaskService::class.java)
    for (i in 1..10) {
        asyncTaskService.executeAsyncTask(i)
        asyncTaskService.executeAsyncTaskPlus(i)
    }
    content.close()
}