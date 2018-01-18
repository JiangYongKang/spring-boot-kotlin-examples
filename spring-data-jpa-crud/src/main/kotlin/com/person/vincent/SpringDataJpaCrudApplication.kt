package com.person.vincent

import com.person.vincent.model.Book
import com.person.vincent.service.BookJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class SpringDataJpaCrudApplication {

    @Autowired
    private lateinit var bookJapRepository: BookJpaRepository

    @PostConstruct
    fun init() {
       val books : List<Book> = listOf(
               Book(null, "Clean Code", "20.00"),
               Book(null, "Think in Java", "18.88")
       )
        bookJapRepository.save(books)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringDataJpaCrudApplication::class.java, *args)
}
