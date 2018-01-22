package com.person.vincent.meta

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Author: vincent
 * Date: 2018-01-22 12:00:00
 * Comment: 一个普通的 service，测试 @WiselyConfiguration 是否可以发现它
 */

@Service
class MetaAnnotationService {

    private val logger = LoggerFactory.getLogger(MetaAnnotationService::class.java)

    fun outputResult() = logger.info("从自定义元注解中获得 bean")
}