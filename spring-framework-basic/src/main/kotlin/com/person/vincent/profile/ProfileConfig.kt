package com.person.vincent.profile

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Author: vincent
 * Date: 2018-01-22 14:17:00
 * Comment: @Profile 可以选择在不同情况下实例化不同的 bean
 */

@Configuration
class ProfileConfig {

    @Bean
    @Profile("development")
    fun developBean() = DemoBean("from development profile")

    @Bean
    @Profile("production")
    fun productionBean() = DemoBean("from production profile")
}