package com.person.vincent

import org.springframework.data.repository.CrudRepository

/**
 * Author: vincent
 * Date: 2018-03-01 13:58:00
 * Comment:
 */

interface PersonRepository : CrudRepository<Person, Long> {

    fun findByFirstName(firstName: String): Person
}