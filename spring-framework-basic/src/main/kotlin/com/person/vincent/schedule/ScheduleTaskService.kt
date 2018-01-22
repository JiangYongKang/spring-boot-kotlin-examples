package com.person.vincent.schedule

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

/**
 * Author: vincent
 * Date: 2018-01-22 10:56:00
 * Comment: 通过 @Scheduled 注解可以声明该方法是一个计划任务
 */

@Service
class ScheduleTaskService {
    private val logger = LoggerFactory.getLogger(ScheduleTaskService::class.java)
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    /**
     * fixedRate 属性每隔固定时间执行
     */
    @Scheduled(fixedRate = 5 * 1000)
    fun reportCurrentTime() = logger.info("每隔五秒执行一次：" + dateFormat.format(Date()))

    /**
     * cron 属性在指定时间执行
     */
    @Scheduled(cron = "00 20 11 ? * *")
    fun fixTimeExecution() = logger.info("在指定时间执行：" + dateFormat.format(Date()))
}