package com.person.vincent.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.http.HttpInputMessage
import org.springframework.http.HttpOutputMessage
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter

/**
 * Author: vincent
 * Date: 2018-02-27 17:00:00
 * Comment: 自定义 HttpMessageConverter
 * 在 Spring MVC 的 Controller 层经常会用到 @RequestBody 和 @ResponseBody，
 * 通过这两个注解，可以在 Controller 中直接使用 Java 对象作为请求参数和返回内容，
 * 而完成这之间转换作用的便是 HttpMessageConverter。
 * 所以我们的业务在有特殊需求的时候，可以通过实现 HttpMessageConverter 来自定义转换器。
 */

class CustomJsonHttpMessageConverter : HttpMessageConverter<Any> {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private var mapper = ObjectMapper()

    private val supportedMediaTypes = arrayListOf<MediaType>(MediaType.APPLICATION_JSON)

    // 判断该转换器是否能将请求内容转换为 Java 对象
    override fun canRead(clazz: Class<*>, mediaType: MediaType?): Boolean {
        logger.info(this.javaClass.name + " -> canRead")
        if (mediaType == null || supportedMediaTypes.contains(mediaType))
            return true
        return false
    }

    // 判断该转换器是否能将 Java 对象转换为返回内容
    override fun canWrite(clazz: Class<*>?, mediaType: MediaType?): Boolean {
        logger.info(this.javaClass.name + " -> canWrite")
        if (mediaType == null || MediaType.ALL == mediaType || supportedMediaTypes.contains(mediaType))
            return true
        return false
    }

    // 获取该转换器支持的 MediaType 类型
    override fun getSupportedMediaTypes() = supportedMediaTypes

    /**
     * 将 Java 对象转换后写入返回内容
     * @outputMessage 一次 http 通讯中的响应部分
     */
    override fun write(t: Any?, contentType: MediaType?, outputMessage: HttpOutputMessage) {
        logger.info(this.javaClass.name + " -> write")
        mapper.writeValue(outputMessage.body, t)
    }

    /**
     * 读取请求内容，并转换为相应的对象
     * @inputMessage 一次 http 通讯中的请求部分
     */
    override fun read(clazz: Class<out Any>?, inputMessage: HttpInputMessage): Any {
        logger.info(this.javaClass.name + " -> read")
        return mapper.readValue(inputMessage.body, clazz)
    }
}
