package com.person.vincent.config

import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Author: vincent
 * Date: 2018-01-26 14:41:00
 * Comment: spring boot 很多自动配置的内容在 WebMvcConfigurer 中
 * 我们可以重新定义它的行为
 */

@Configuration
class WebMvcConfig: WebMvcConfigurer {

    /**
     * 自动配置的 formatter
     */
    override fun addFormatters(registry: FormatterRegistry) {
        super.addFormatters(registry)
    }

    /**
     * 自动配置的 message converters
     */
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        super.configureMessageConverters(converters)
    }

    /**
     * 自动配置的 view controller
     * 这里定义了自己的行为，当访问 http://localhost:8080/spring-boot/ 时，会跳转到 index.html
     */
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("/index")
    }
}