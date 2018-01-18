package com.person.vincent.service

import com.person.vincent.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookJpaRepository : JpaRepository<Book, Int>