package com.person.vincent.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Author: vincent
 * Date: 2018-02-08 17:17:00
 * Comment:
 * @ConfigurationProperties 注解获取 application.yml 配置文件中的内容
 * spring.thymeleaf 获取指定前缀的内容
 */

@Component
@ConfigurationProperties(prefix = "spring.thymeleaf")
class ThymeleafConfig {
    var cache: Boolean? = null
    var enabled: Boolean? = null
    var mode: String? = null
    var prefix: String? = null
    var suffix: String? = null
}
