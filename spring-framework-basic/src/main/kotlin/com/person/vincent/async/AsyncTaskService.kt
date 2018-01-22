package com.person.vincent.async

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

/**
 * Author: vincent
 * Date: 2018-01-22 10:37:00
 * Comment: @Async 注解表明该方法是个异步的方法，如果注解在类上，代表这个类上的所有方法都是异步的
 */

@Service
class AsyncTaskService {

    @Async
    fun executeAsyncTask(i: Int) = println("执行异步任务 --> " + i)

    @Async
    fun executeAsyncTaskPlus(i: Int) = println("执行异步任务 >>> " + i)
}