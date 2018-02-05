package com.person.vincent.config

import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
import org.springframework.context.ApplicationListener

/**
 * Author: vincent
 * Date: 2018-02-05 11:04:00
 * Comment: 创建上下文之前触发的事件，它通常被用作配置环境的监听，可以在这里修改默认的配置信息，或者增加额外的配置信息
 */

class ApplicationEnvironmentPrepared : ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private val logger = LoggerFactory.getLogger(ApplicationEnvironmentPrepared::class.java)

    override fun onApplicationEvent(event: ApplicationEnvironmentPreparedEvent?) {
        logger.info(">>> the initialization context loads the default configuration")
    }
}