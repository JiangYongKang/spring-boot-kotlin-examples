package com.person.vincent.meta

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Author: vincent
 * Date: 2018-01-22 11:53:00
 * Comment: 自定义元注解
 * @WiselyConfiguration 组合了 @Configuration @ComponentScan
 * 并且重写了 @ComponentScan 中的 value() 方法
 */

@MustBeDocumented
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@Configuration
@ComponentScan
annotation class WiselyConfiguration(vararg val value: String = [])