package com.person.vincent.repository

import com.person.vincent.model.Account
import org.springframework.data.repository.CrudRepository

/**
 * Author: vincent
 * Date: 2018-03-16 09:54:00
 * Comment:
 */

interface AccountRepository : CrudRepository<Account, Long>