package com.person.vincent.conditional

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata

/**
 * Author: vincent
 * Date: 2018-01-22 11:30:00
 * Comment: 重写 matches 方法来判定是否是 Windows 操作系统
 */
class WindowsCondition: Condition {

    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata)
        = context.environment.getProperty("os.name").contains("Windows")
}