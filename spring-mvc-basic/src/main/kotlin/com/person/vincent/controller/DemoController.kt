package com.person.vincent.controller

import com.person.vincent.model.DemoObject
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

/**
 * Author: vincent
 * Date: 2018-01-22 16:21:00
 * Comment:
 * @Controller 声明控制器
 * @RequestMapping 声明映射路径，可以定义为数组，匹配多个路径。produces 属性定义数据格式，可以省略
 * @ResponseBody 返回结果处理为 JSON
 */
@Controller
@RequestMapping("/demo")
class DemoController {

    @ResponseBody
    @RequestMapping(produces = ["text/plain;charset=UTF-8"])
    fun index(request: HttpServletRequest) = "url: " + request.requestURL + " can access"

    @ResponseBody
    @RequestMapping(value = ["/path/var/{s}"], produces = ["text/plain;charset=UTF-8"])
    fun demoPathVar(@PathVariable s: String, request: HttpServletRequest) = "url: " + request.requestURL + " can access s: " + s

    @ResponseBody
    @RequestMapping(value = ["/requestParam"], produces = ["text/plain;charset=UTF-8"])
    fun passRequestParam(id: Long, request: HttpServletRequest) = "url: " + request.requestURL + " can access, id: " + id

    @ResponseBody
    @RequestMapping(value = ["/object"], produces = ["application/json;charset=UTF-8"])
    fun passObject(demoObject: DemoObject, request: HttpServletRequest) = "url: " + request.requestURL + " can access, object id: " + demoObject.id + ", object name: " + demoObject.name

    @ResponseBody
    @RequestMapping(value = ["/name1", "/name2"], produces = ["text/plain;charset=UTF-8"])
    fun remove(request: HttpServletRequest) = "url: " + request.requestURL + " can access"
}