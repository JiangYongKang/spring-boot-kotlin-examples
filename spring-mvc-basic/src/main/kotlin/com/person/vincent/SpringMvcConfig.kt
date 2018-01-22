package com.person.vincent

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.thymeleaf.spring4.SpringTemplateEngine
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring4.view.ThymeleafViewResolver


/**
 * Author: vincent
 * Date: 2018-01-22 14:37:00
 * Comment: spring MVC 与 thymeleaf 的整和
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.person.vincent")
class SpringMvcConfig {

    @Bean
    fun templateResolver(): SpringResourceTemplateResolver {
        val templateResolver = SpringResourceTemplateResolver()
        // 这里指的是 war 包中视图模板的所在路径
        templateResolver.prefix = "/WEB-INF/classes/templates/"
        templateResolver.suffix = ".html"
        templateResolver.characterEncoding = "UTF-8"
        templateResolver.setTemplateMode("HTML5")
        return templateResolver
    }

    @Bean
    fun templateEngine(): SpringTemplateEngine {
        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(templateResolver())
        return templateEngine
    }

    @Bean
    fun viewResolver(templateEngine: SpringTemplateEngine): ViewResolver {
        val viewResolver = ThymeleafViewResolver()
        viewResolver.templateEngine = templateEngine
        viewResolver.characterEncoding = "UTF-8"
        return viewResolver
    }
}