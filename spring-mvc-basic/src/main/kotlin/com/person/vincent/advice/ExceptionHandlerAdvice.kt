package com.person.vincent.advice

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.ModelAndView
import java.util.*

/**
 * Author: vincent
 * Date: 2018-01-22 17:40:00
 * Comment: @ControllerAdvice 注解设置控制器的全局性配置
 */

@ControllerAdvice
class ExceptionHandlerAdvice {

    /**
     * @ExceptionHandler 定义全局处理，value 属性过滤拦截条件，这里拦截了全部的 Exception
     */
    @ExceptionHandler(value = [(Exception::class)])
    fun exception(exception: Exception, request: WebRequest): ModelAndView {
        val modelAndView = ModelAndView("error")
        modelAndView.addObject("errorMessage", Optional.ofNullable(exception.message).get())
        return modelAndView
    }


    /**
     * @ModelAttribute 注解将键值对添加到全局，所有注解了 @RequestMapping 的注解可以拿到值
     */
    @ModelAttribute
    fun addGlobalAttributes(model: Model) {
        model.addAttribute("GLOBAL_ATTRIBUTES", "全局属性")
    }


}