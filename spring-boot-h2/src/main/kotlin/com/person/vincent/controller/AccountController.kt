package com.person.vincent.controller

import com.person.vincent.model.Account
import com.person.vincent.repository.AccountRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Author: vincent
 * Date: 2018-03-16 10:57:00
 * Comment:
 */

@RestController
@RequestMapping("/account")
class AccountController (
        val accountRepository: AccountRepository
) {

    @GetMapping(value = ["", "/"])
    fun index() :Iterable<Account> = accountRepository.findAll()
}