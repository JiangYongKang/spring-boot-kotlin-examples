package com.person.vincent.scope

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

/**
 * Author: vincent
 * Date: 2018-01-22 13:43:00
 * Comment: @Scope("request") 为每一个 http request 创建一个新的 bean
 */

@Service
@Scope("request")
class RequestService