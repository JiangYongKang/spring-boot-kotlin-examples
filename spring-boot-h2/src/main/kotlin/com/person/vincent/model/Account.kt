package com.person.vincent.model

import javax.persistence.*

/**
 * Author: vincent
 * Date: 2018-03-16 09:52:00
 * Comment:
 */

@Entity
@Table(name = "account")
data class Account(
        @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,

        @Column(name = "username")
        val username: String = "",

        @Column(name = "password")
        val password: String = ""
)