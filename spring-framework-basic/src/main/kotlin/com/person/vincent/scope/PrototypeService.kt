package com.person.vincent.scope

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

/**
 * Author: vincent
 * Date: 2018-01-22 13:41:00
 * Comment: @Scope("prototype") 每次调用创建一个 bean 的实例
 */

@Service
@Scope("prototype")
class PrototypeService