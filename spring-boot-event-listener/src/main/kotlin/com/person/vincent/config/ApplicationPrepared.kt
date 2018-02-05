package com.person.vincent.config

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationPreparedEvent
import org.springframework.context.ApplicationListener

/**
 * Author: vincent
 * Date: 2018-02-05 11:17:00
 * Comment: ApplicationPreparedEvent 会在所有的 bean 加载完成之后，准备刷新之前触发
 */

class ApplicationPrepared : ApplicationListener<ApplicationPreparedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationPrepared::class.java)

    override fun onApplicationEvent(event: ApplicationPreparedEvent?) {
        logger.info(">>> the bean is loaded and ready for refresh")
    }
}