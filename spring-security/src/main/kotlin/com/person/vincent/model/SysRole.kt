package com.person.vincent.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Author: vincent
 * Date: 2018-01-19 10:33:00
 * Comment:
 */
@Entity
data class SysRole(
        @Id @GeneratedValue
        var id: Long? = null,

        var name: String? = null
)