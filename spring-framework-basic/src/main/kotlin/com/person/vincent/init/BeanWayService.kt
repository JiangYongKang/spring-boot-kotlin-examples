package com.person.vincent.init

import org.slf4j.LoggerFactory

/**
 * Author: vincent
 * Date: 2018-01-22 13:58:00
 * Comment:
 */

class BeanWayService {

    private val logger = LoggerFactory.getLogger(BeanWayService::class.java)

    fun init() = logger.info("初始化")

    init {
        logger.info("初始化构造函数")
    }

    fun destroy() = logger.info("销毁对象")
}