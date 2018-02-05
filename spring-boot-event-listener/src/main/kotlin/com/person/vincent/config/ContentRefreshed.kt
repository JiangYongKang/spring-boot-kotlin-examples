package com.person.vincent.config

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

/**
 * Author: vincent
 * Date: 2018-02-05 11:01:00
 * Comment:
 */

@Component
class ContentRefreshed : ApplicationListener<ContextRefreshedEvent> {

    private val logger = LoggerFactory.getLogger(ContentRefreshed::class.java)

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        logger.info(">>> content refreshed")
    }
}