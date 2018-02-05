package com.person.vincent

import com.person.vincent.config.ApplicationEnvironmentPrepared
import com.person.vincent.config.ApplicationFailed
import com.person.vincent.config.ApplicationPrepared
import com.person.vincent.config.ApplicationStarting
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Author: vincent
 * Date: 2018-02-05 09:56:00
 * Comment:
 * 通常情况下，我们定义一个事件，需要实现  ApplicationListener 接口并提供泛型参数。
 * 不同的事件在启动流程的不同节点被触发，有的是启动时，有的是在加载完 bean 之后等等。。。
 * 在加载完 bean 之后的事件触发器可以通过 @Component 注解成为一个 bean
 * 在尚未开始加载 bean 之前就会被触发的事件，必须通过 application.addListeners() 方法进行添加
 */
@SpringBootApplication
class SpringBootEventListenerApplication

fun main(args: Array<String>) {
    val application = SpringApplication(SpringBootEventListenerApplication::class.java)
    application.addListeners(ApplicationStarting())
    application.addListeners(ApplicationEnvironmentPrepared())
    application.addListeners(ApplicationPrepared())
    application.addListeners(ApplicationFailed())
    application.run(*args)
}