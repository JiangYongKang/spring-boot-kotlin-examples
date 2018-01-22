package com.person.vincent.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Author: vincent
 * Date: 2018-01-22 15:18:00
 * Comment:
 */
@Controller
class HelloController {

    @RequestMapping("/")
    fun hello() = "index"
}