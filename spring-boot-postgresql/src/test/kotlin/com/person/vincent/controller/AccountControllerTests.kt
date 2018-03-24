package com.person.vincent.controller

import com.person.vincent.domain.Account
import com.person.vincent.service.AccountService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * Author: vincent
 * Date: 2018-03-24 10:08:00
 * Comment:
 */

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner::class)
@Transactional
class AccountControllerTests {

    @Test
    fun loadContentTest() {
    }

    @Resource
    private lateinit var accountService: AccountService

    @Resource
    private lateinit var mockMvc: MockMvc

    private val logger = LoggerFactory.getLogger(AccountControllerTests::class.java)

    /**
     * mockMvc 模拟 mvc 上下文执行环境，@Before 注解的方法在执行测试方法之前执行
     */
    @Before
    fun beforeAction() {
        accountService.destroyAll()
        accountService.saveAll(listOf(Account("Vincent"), Account("Jacob"), Account("Anthony")))
    }

    @Test
    fun indexTest() {
        mockMvc.perform(get("/account")).andExpect(status().isOk)
        logger.info(content().toString())
    }

    @Test
    fun showTest() {
        val account = accountService.findByName("Vincent")
        mockMvc.perform(get("/account/${account.id}")).andExpect(status().isOk)
        logger.info(content().toString())
    }

    @Test
    @Rollback
    fun saveTest() {
        val request = post("/account")
                .header("Content-Type", "application/json")
                .content("{\"name\": \"vincent\"}")
        mockMvc.perform(request).andExpect(status().isOk)
    }

    @Test
    fun editTest() {
        val request = post("/account")
                .header("Content-Type", "application/json")
                .content("{\"id\": \"1\", \"name\": \"vincent\"}")
        mockMvc.perform(request).andExpect(status().isOk)
    }

    @Test
    @Rollback
    fun destroyTest() {
        val account = accountService.findByName("Vincent")
        mockMvc.perform(delete("/account/${account.id}")).andExpect(status().isOk)
    }

    @Test
    @Rollback
    fun destroyAllTest() {
        mockMvc.perform(delete("/account")).andExpect(status().isOk)
    }
}