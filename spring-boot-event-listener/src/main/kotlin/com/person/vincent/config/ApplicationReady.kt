package com.person.vincent.config

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

/**
 * Author: vincent
 * Date: 2018-02-05 10:22:00
 * Comment: ApplicationReadyEvent 在任何应用程序和命令行参数被调用后发送，它表示应用程序已准备好处理请求。
 */

@Component
class ApplicationReady : ApplicationListener<ApplicationReadyEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationReady::class.java)

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        logger.info(">>> ready to process the request")
    }
}