package com.person.vincent.async

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

/**
 * Author: vincent
 * Date: 2018-01-22 10:37:00
 * Comment: @EnableAsync 注解开启异步的支持，重写方法设定线程池的相关数据，并且初始化
 */

@Configuration
@EnableAsync
@ComponentScan("com.person.vincent.async")
class TaskExecutorConfig : AsyncConfigurer {

    override fun getAsyncExecutor(): Executor {
        val taskExecutor = ThreadPoolTaskExecutor()
        taskExecutor.corePoolSize = 5
        taskExecutor.maxPoolSize = 10
        taskExecutor.setQueueCapacity(25)
        taskExecutor.initialize()
        return taskExecutor
    }

    override fun getAsyncUncaughtExceptionHandler(): AsyncUncaughtExceptionHandler? {
        return null
    }
}