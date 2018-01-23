package com.person.vincent.service

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.context.request.async.DeferredResult

/**
 * Author: vincent
 * Date: 2018-01-22 18:23:00
 * Comment: 一个计划任务，每隔 5 秒执行一次
 */

@Service
class PushService {

    private var deferredResult = DeferredResult<String>()

    fun getAsyncUpdate() = deferredResult.result!!

    /**
     * 每隔 5 秒定时更新
     */
    @Scheduled(fixedDelay = 5 * 1000)
    fun refresh() = deferredResult.setResult(System.currentTimeMillis().toString())

}