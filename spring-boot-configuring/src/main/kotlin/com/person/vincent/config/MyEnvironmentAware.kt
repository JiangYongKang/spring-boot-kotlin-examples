package com.person.vincent.config

import org.slf4j.LoggerFactory
import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

/**
 * Author: vincent
 * Date: 2018-02-09 15:59:00
 * Comment: 启动时加载环境变量，包括系统级别的变量。
 * 在这里可以通过 environment 来设置未在配置文件以及外部声明的变量值
 */

@Configuration
class MyEnvironmentAware : EnvironmentAware {

    private val logger = LoggerFactory.getLogger(MyEnvironmentAware::class.java)

    override fun setEnvironment(environment: Environment) {
        logger.info("JAVA_HOME: " + environment.getProperty("JAVA_HOME"))
        logger.info("SERVER_SERVLET_CONTENT_PATH: " + environment.getProperty("server.servlet.content-path"))
    }
}