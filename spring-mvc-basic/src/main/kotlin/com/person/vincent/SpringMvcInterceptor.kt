package com.person.vincent

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Author: vincent
 * Date: 2018-01-22 16:52:00
 * Comment: 继承 HandlerInterceptorAdapter 类设置拦截器，在控制台打印请求的响应时间
 * WebMvcConfigurer 中有很多全局性的配置 API，实现它可以定义自己的全局设置
 */

@Configuration
class SpringMvcInterceptor : WebMvcConfigurer, HandlerInterceptorAdapter() {

    private val logger = LoggerFactory.getLogger(SpringMvcInterceptor::class.java)

    /**
     * 请求执行前执行
     */
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val startTime = System.currentTimeMillis()
        request.setAttribute("startTime", startTime)
        return true
    }

    /**
     * 请求结束后执行
     * modelAndView 需要设置成可以为空的类型，否则会抛出 java.lang.IllegalArgumentException: Parameter specified as non-null is null 异常
     */
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        val startTime = request.getAttribute("startTime") as Long
        request.removeAttribute("startTime")
        val responseTime = System.currentTimeMillis() - startTime
        logger.info("response time: " + responseTime + "ms")
        request.setAttribute("handlingTime", responseTime)
    }

    /**
     * 加载自定义拦截器到 spring 容器中。
     */
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(this)
    }
}