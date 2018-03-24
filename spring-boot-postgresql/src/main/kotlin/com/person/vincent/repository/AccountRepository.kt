package com.person.vincent.repository

import com.person.vincent.domain.Account
import org.springframework.data.repository.CrudRepository

/**
 * Author: vincent
 * Date: 2018-03-23 22:59:00
 * Comment: JPA支持两种表达查询的方法来检索实体和来自数据库的其他持久化数据
 */

interface AccountRepository: CrudRepository<Account, Long> {

    // JPQL (Java Persistence Query Language)
    fun findByOpenId(openId: String)

    fun findByName(name: String): Account
}