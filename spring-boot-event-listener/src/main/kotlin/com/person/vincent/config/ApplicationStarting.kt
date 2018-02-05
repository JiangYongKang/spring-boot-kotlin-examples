package com.person.vincent.config

import org.springframework.boot.Banner
import org.springframework.boot.context.event.ApplicationStartingEvent
import org.springframework.context.ApplicationListener

/**
 * Author: vincent
 * Date: 2018-02-05 10:00:00
 * Comment:
 * ApplicationStartingEvent 是在创建 ApplicationContext 之前触发的，所以不能将它设置为一个 bean
 * 只能通过 application.addListeners(ApplicationStarting()) 来添加进去
 * 这也是为什么这个监听器可以关闭启动 banner 的原因
 */

class ApplicationStarting : ApplicationListener<ApplicationStartingEvent> {

    override fun onApplicationEvent(event: ApplicationStartingEvent) {
        val application = event.springApplication
        application.setBannerMode(Banner.Mode.OFF)
    }
}