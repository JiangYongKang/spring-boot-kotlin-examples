package com.person.vincent.init

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Author: vincent
 * Date: 2018-01-22 14:02:00
 * Comment: @Bean 注解可以通过属性来指定初始化方法和销毁时要执行的方法
 *
 */

@Configuration
@ComponentScan("com.person.vincent.init")
class PrePostConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    fun beanWayService() = BeanWayService()
}