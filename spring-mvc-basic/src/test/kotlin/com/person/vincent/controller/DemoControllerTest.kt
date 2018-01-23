package com.person.vincent.controller

import com.person.vincent.SpringMvcConfig
import com.person.vincent.SpringMvcInterceptor
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpSession
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

/**
 * Author: vincent
 * Date: 2018-01-22 19:53:00
 * Comment:
 * @WebAppConfiguration 声明 web 配置文件的位置
 *
 */

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = [SpringMvcConfig::class, SpringMvcInterceptor::class])
@WebAppConfiguration("src/main/resources")
class DemoControllerTest {

    private var mockMvc: MockMvc? = null

    // 必须注入 WebApplicationContext，用于初始化 mvc 上下文
    @Autowired
    private lateinit var wac: WebApplicationContext

    // 注入模拟用的 http session
    @Autowired
    private lateinit var session: MockHttpSession

    // 注入模拟用的 http request
    @Autowired
    private lateinit var request: MockHttpServletRequest

    /**
     * mockMvc 模拟 mvc 上下文执行环境，@Before 注解的方法在执行测试方法之前执行
     */
    @Before
    fun setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
    }

    @Test
    fun indexTest() {
        mockMvc!!.perform(get("/demo"))
                .andExpect(status().isOk)
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("url: http://localhost/demo can access"))
    }

    @Test
    fun demoPathVarTest() {
        mockMvc!!.perform(get("/demo/path/var/1"))
                .andExpect(status().isOk)
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("url: http://localhost/demo/path/var/1 can access s: 1"))
    }

    @Test
    fun passRequestParamTest() {
        mockMvc!!.perform(get("/demo/requestParam?id=1"))
                .andExpect(status().isOk)
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("url: http://localhost/demo/requestParam can access, id: 1"))
    }

    @Test
    fun passObjectTest() {
        mockMvc!!.perform(get("/demo/object?id=1&name=vincent"))
                .andExpect(status().isOk)
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("url: http://localhost/demo/object can access, object id: 1, object name: vincent"))
    }

    @Test
    fun removeTest() {
        mockMvc!!.perform(get("/demo/name1"))
                .andExpect(status().isOk)
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("url: http://localhost/demo/name1 can access"))

        mockMvc!!.perform(get("/demo/name2"))
                .andExpect(status().isOk)
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("url: http://localhost/demo/name2 can access"))
    }
}