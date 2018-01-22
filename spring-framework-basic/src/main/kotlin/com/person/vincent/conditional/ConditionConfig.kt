package com.person.vincent.conditional

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration

/**
 * Author: vincent
 * Date: 2018-01-22 11:28:00
 * Comment: 配置类
 * 通过 @Conditional 注解，判定在不同的操作系统之下，创建不同的 bean，判定类通过属性传入
 */

@Configuration
class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition::class)
    fun windowsListService() = WindowsListService()

    @Bean
    @Conditional(MacOSCondition::class)
    fun macOSListService() = MacOSListService()
}