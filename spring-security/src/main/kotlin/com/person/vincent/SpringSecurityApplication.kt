package com.person.vincent

import com.person.vincent.model.Message
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
@Controller
class SpringSecurityApplication {

    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("msg", Message("标题", "内容", "管理员才能看到"))
        return "home"
    }

    @GetMapping("/login")
    fun login() = "login"
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringSecurityApplication::class.java, *args)
}
