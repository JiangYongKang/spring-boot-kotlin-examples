package com.person.vincent.repository

import com.person.vincent.model.SysUser
import org.springframework.data.jpa.repository.JpaRepository

interface SysUserRepository : JpaRepository<SysUser, Long> {

    fun findByUsername(username: String): SysUser
}