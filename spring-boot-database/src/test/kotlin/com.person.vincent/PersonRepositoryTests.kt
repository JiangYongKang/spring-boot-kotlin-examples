package com.person.vincent

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

/**
 * Author: vincent
 * Date: 2018-03-02 15:37:00
 * Comment:
 */

@RunWith(SpringRunner::class)
@SpringBootTest
class PersonRepositoryTests {

    @Resource
    private lateinit var repository: PersonRepository

    @Before
    fun beforeAction() {
        repository.deleteAll()
        repository.save(Person("Jack", "Bauer"))
        repository.save(Person("Chloe", "O'Brian"))
        repository.save(Person("Kim", "Bauer"))
        repository.save(Person("David", "Palmer"))
    }

    @Test
    fun saveTest() {
        repository.save(Person("Michelle", "Dessler"))
    }

    @Test
    fun findByFirstNameTest() {
        val david = repository.findByFirstName("David")
        Assert.assertEquals(david.firstName, "David")
        Assert.assertEquals(david.lastName, "Palmer")
    }
}