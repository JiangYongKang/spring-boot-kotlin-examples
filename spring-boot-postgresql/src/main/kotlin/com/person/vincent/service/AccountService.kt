package com.person.vincent.service

import com.person.vincent.domain.Account
import com.person.vincent.repository.AccountRepository
import org.springframework.stereotype.Service

/**
 * Author: vincent
 * Date: 2018-03-24 09:45:00
 * Comment:
 */

@Service
class AccountService(
        val accountRepository: AccountRepository
) {

    fun findAll(): MutableIterable<Account> = accountRepository.findAll()

    fun findById(id: Long) = accountRepository.findById(id).get()

    fun findByName(name: String) = accountRepository.findByName(name)

    fun save(account: Account): Account = accountRepository.save(account)

    fun saveAll(accounts: List<Account>) = accountRepository.saveAll(accounts)

    fun update(account: Account) = save(account)

    fun destroy(account: Account) = accountRepository.delete(account)

    fun destroyById(id: Long) = accountRepository.deleteById(id)

    fun destroyAll() = accountRepository.deleteAll()
}