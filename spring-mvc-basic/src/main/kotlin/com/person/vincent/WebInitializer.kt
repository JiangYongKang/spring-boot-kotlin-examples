package com.person.vincent

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.ServletContext

/**
 * Author: vincent
 * Date: 2018-01-22 14:55:00
 * Comment: WebApplicationInitializer 是 spring 用来配置 servlet 3.0+ 的接口，用来代替 web.xml
 */

class WebInitializer : WebApplicationInitializer {

    override fun onStartup(servletContext: ServletContext) {
        val ctx = AnnotationConfigWebApplicationContext()
        ctx.register(SpringMvcConfig::class.java)
        ctx.servletContext = servletContext
        val servlet = servletContext.addServlet("dispatcher", DispatcherServlet(ctx))
        // 设置拦截所有请求
        servlet.addMapping("/")
        servlet.setLoadOnStartup(1)
        // 开启异步方法的支持
        servlet.setAsyncSupported(true)
    }
}