package com.person.vincent

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootBannerApplication

fun main(args: Array<String>) {
    val application = SpringApplication(SpringBootBannerApplication::class.java)
    // 关闭 banner 输出
    // application.setBannerMode(Banner.Mode.OFF)
    // 使用自己实现的 banner 输出
    // application.setBanner(MyBanner())
    application.run(*args)
}
