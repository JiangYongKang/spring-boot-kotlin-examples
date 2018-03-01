package com.person.vincent

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

/**
 * Author: vincent
 * Date: 2018-03-01 14:02:00
 * Comment:
 */

@RunWith(SpringRunner::class)
@SpringBootTest
class PersonRepositoryTests {

    @Resource
    private lateinit var repository: PersonRepository

    @Before
    fun initialize() {
        repository.saveAll(
                arrayListOf(Person(1, "vincent", "vincent"),
                        Person(2, "alice", "alice")
                )
        )
    }

    @Test
    fun findAllTest() {
        repository.findAll()
    }
}