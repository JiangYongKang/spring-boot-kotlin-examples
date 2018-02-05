package com.person.vincent.config

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationFailedEvent
import org.springframework.context.ApplicationListener

/**
 * Author: vincent
 * Date: 2018-02-05 11:32:00
 * Comment: application 启动失败时发送的事件
 */

class ApplicationFailed : ApplicationListener<ApplicationFailedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationFailed::class.java)

    override fun onApplicationEvent(event: ApplicationFailedEvent?) {
        logger.info(">>> start failed")
    }
}
