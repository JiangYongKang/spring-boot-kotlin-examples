package com.person.vincent.config

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

/**
 * Author: vincent
 * Date: 2018-02-05 10:45:00
 * Comment: 在刷新上下文之后，但在调用任何应用程序和命令行参赛者之前，会发送一个 ApplicationStartedEvent。
 */

@Component
class ApplicationStarted : ApplicationListener<ApplicationStartedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationStarted::class.java)

    override fun onApplicationEvent(event: ApplicationStartedEvent) {
        logger.info(">>> refresh completed")
    }
}