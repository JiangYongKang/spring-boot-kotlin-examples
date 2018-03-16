package com.person.vincent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootBannerApplication

fun main(args: Array<String>) {
    runApplication<SpringBootBannerApplication>(*args) {
        // 关闭 banner 输出
        // this.setBannerMode(Banner.Mode.OFF)
        // 使用自己实现的 banner 输出
        // this.setBanner(MyBanner())
    }
}
