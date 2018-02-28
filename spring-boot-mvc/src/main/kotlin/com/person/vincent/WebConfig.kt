package com.person.vincent

import com.person.vincent.config.CustomJsonHttpMessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Author: vincent
 * Date: 2018-02-27 17:42:00
 * Comment: 将自定义的 CustomJsonHttpMessageConverter 配置到 Spring 容器中，它才能正常工作
 */

@Configuration
class WebConfig : WebMvcConfigurer {

    /**
     * 添加自定义的转换器到 Spring 容器中
     */
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(CustomJsonHttpMessageConverter())
        super.configureMessageConverters(converters)
    }

    /**
     * 设置静态资源的路径
     */
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/")
    }
}
