package com.person.vincent.schedule

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

/**
 * Author: vincent
 * Date: 2018-01-22 11:06:00
 * Comment: @EnableScheduling 注解来开启对计划任务的支持
 */

@Configuration
@EnableScheduling
@ComponentScan("com.person.vincent.schedule")
class TaskSchedulerConfig