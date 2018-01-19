package com.person.vincent.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.*
import java.util.ArrayList

/**
 * Author: vincent
 * Date: 2018-01-19 10:31:00
 * Comment:
 */
@Entity
class SysUser : UserDetails {

    @Id
    @GeneratedValue
    private var id: Long? = null

    private var username: String? = null

    private var password: String? = null

    @ManyToMany(cascade = [(CascadeType.REFRESH)], fetch = FetchType.EAGER)
    var roles: List<SysRole> = ArrayList()

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val authorities = ArrayList<GrantedAuthority>()
        this.roles.forEach { role -> authorities.add(SimpleGrantedAuthority(role.name)) }
        return authorities
    }

    override fun getPassword(): String? {
        return this.password
    }

    override fun getUsername(): String? {
        return this.username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getId(): Long? {
        return this.id
    }

    fun setId(id: Long) {
        this.id = id
    }
}
