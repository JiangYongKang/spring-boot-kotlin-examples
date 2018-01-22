package com.person.vincent.init

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

/**
 * Author: vincent
 * Date: 2018-01-22 14:07:00
 * Comment:
 * @PostConstruct 注解会使方法在构造函数执行完毕之后立即执行
 * @PreDestroy 注解会使方法在对象销毁的时候执行
 */
@Service
class AnnotationBeanService {

    private val logger = LoggerFactory.getLogger(AnnotationBeanService::class.java)

    init {
        logger.info("初始化构造函数...")
    }

    @PostConstruct
    fun init() = logger.info("初始化...")

    @PreDestroy
    fun destroy() = logger.info("销毁对象...")
}