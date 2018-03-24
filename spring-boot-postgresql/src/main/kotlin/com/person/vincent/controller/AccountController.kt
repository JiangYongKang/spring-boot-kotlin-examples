package com.person.vincent.controller

import com.person.vincent.domain.Account
import com.person.vincent.service.AccountService
import org.springframework.web.bind.annotation.*

/**
 * Author: vincent
 * Date: 2018-03-24 09:50:00
 * Comment:
 */

@RestController
@RequestMapping("/account")
class AccountController(
        val accountService: AccountService
) {
    @GetMapping(value = ["", "/"])
    fun index() = accountService.findAll()

    @GetMapping(value = ["/{id}"])
    fun show(@PathVariable id: Long) = accountService.findById(id)

    @PostMapping(value = ["", "/"])
    fun save(@RequestBody account: Account): Account = accountService.save(account)

    @PutMapping(value = ["", "/"])
    fun edit(@RequestBody account: Account): Account = accountService.update(account)

    @DeleteMapping(value = ["/{id}"])
    fun destroy(@PathVariable id: Long) = accountService.destroyById(id)

    @DeleteMapping(value = ["", "/"])
    fun destroyAll() = accountService.destroyAll()
}