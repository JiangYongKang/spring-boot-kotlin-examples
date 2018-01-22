package com.person.vincent.scope

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

/**
 * Author: vincent
 * Date: 2018-01-22 13:44:00
 * Comment: @Scope("session") 为每一个 http session 创建一个 bean 的实例
 */

@Service
@Scope("session")
class SessionService