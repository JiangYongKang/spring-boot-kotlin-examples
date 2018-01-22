package com.person.vincent.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * Author: vincent
 * Date: 2018-01-22 17:54:00
 * Comment: 手动抛出异常，测试全局异常配置
 */

@Controller
class ErrorController {

    @GetMapping("/error")
    fun error(): Nothing = throw Exception("手动抛出的异常！")
}