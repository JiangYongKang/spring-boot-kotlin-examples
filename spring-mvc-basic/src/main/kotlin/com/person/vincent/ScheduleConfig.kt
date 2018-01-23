package com.person.vincent

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Author: vincent
 * Date: 2018-01-22 18:39:00
 * Comment:
 */
@Configuration
@EnableScheduling
@ComponentScan("com.person.vincent")
class ScheduleConfig : WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/async").setViewName("/async")
    }
}