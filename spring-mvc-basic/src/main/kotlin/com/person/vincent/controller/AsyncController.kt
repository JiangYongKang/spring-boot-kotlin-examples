package com.person.vincent.controller

import com.person.vincent.service.PushService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Author: vincent
 * Date: 2018-01-22 18:22:00
 * Comment:
 */

@Controller
class AsyncController {

    @Autowired
    private lateinit var service: PushService

    @ResponseBody
    @RequestMapping("/defer")
    fun deferredCall() = service.getAsyncUpdate()
}