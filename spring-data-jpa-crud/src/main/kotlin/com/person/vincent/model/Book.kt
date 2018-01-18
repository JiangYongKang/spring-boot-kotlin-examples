package com.person.vincent.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "book")
data class Book(
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,

        @Column
        val title: String? = null,

        @Column
        val price: String? = null
): Serializable