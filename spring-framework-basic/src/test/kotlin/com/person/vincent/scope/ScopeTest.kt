package com.person.vincent.scope

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Author: vincent
 * Date: 2018-01-22 13:51:00
 * Comment:
 */

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [ScopeConfig::class])
class ScopeTest {

    @Autowired
    private lateinit var singletonServiceOne: SingletonService

    @Autowired
    private lateinit var singletonServiceTwo: SingletonService

    @Autowired
    private lateinit var prototypeServiceOne: PrototypeService

    @Autowired
    private lateinit var prototypeServiceTwo: PrototypeService

    @Test
    fun singleton() {
        assert(singletonServiceOne == singletonServiceTwo)
    }

    @Test
    fun prototype() {
        assert(prototypeServiceOne != prototypeServiceTwo)
    }
}