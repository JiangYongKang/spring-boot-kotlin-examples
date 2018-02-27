package com.person.vincent.controller

import com.person.vincent.model.User
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Author: vincent
 * Date: 2018-02-24 15:07:00
 * Comment:
 * 通过 @RestController 注解来声明一个控制器。
 * 通过 @RequestMapping 或者 @GetMapping 系列的注解来处理 http 请求
 */

@RestController
@RequestMapping("/users")
class BasicRestController {

    private var users = arrayListOf(
            User(UUID.randomUUID().toString(), "vincent", 18),
            User(UUID.randomUUID().toString(), "lucy", 18)
    )

    @GetMapping(value = ["", "/"])
    fun index() = users

    @PostMapping(value = ["", "/"])
    fun create(@RequestBody user: User) = users.add(user)

    @PutMapping(value = ["", "/"])
    fun update(@RequestBody user: User) {
        users.toMutableList().forEach {
            if (it.id == user.id) {
                it.name = user.name
                it.age = user.age
            }
        }
    }

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: String) = users.toMutableList().forEach {
        if (it.id == id)
            users.remove(it)
    }
}