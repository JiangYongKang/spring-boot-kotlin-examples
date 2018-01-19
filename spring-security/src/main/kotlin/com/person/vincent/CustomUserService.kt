package com.person.vincent

import com.person.vincent.repository.SysUserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import javax.annotation.Resource

class CustomUserService : UserDetailsService {

    @Resource
    private lateinit var userRepository: SysUserRepository

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUsername(username)
    }
}