package com.person.vincent

import javax.persistence.*

/**
 * Author: vincent
 * Date: 2018-03-01 12:02:00
 * Comment:
 */

@Entity
@Table(name = "person")
data class Person(
        @Id @Column(name = "id") @GeneratedValue
        val id: Long = -1,

        @Column(nullable = false, name = "first_name")
        val firstName: String = "",

        @Column(nullable = false, name = "last_name")
        val lastName: String = ""
)