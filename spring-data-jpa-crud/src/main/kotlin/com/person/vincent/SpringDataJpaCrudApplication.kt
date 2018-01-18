package com.person.vincent

import com.person.vincent.model.Book
import com.person.vincent.service.BookJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.jdbc.core.JdbcTemplate
import javax.annotation.PostConstruct

@SpringBootApplication
class SpringDataJpaCrudApplication : CommandLineRunner {

    @Autowired
    private lateinit var bookJapRepository: BookJpaRepository

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    @PostConstruct
    fun init() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS `book`")
        val createTableSqL = """
            CREATE TABLE book(
              id        INT AUTO_INCREMENT PRIMARY KEY,
              title     VARCHAR(64)        NULL,
              price     DOUBLE DEFAULT '0' NULL
            ) ENGINE = InnoDB
        """
        jdbcTemplate.execute(createTableSqL)
    }

    override fun run(vararg p0: String?) {
        val books: List<Book> = listOf(
                Book(null, "Clean Code", "20.00"),
                Book(null, "Think in Java", "18.88")
        )
        bookJapRepository.save(books)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringDataJpaCrudApplication::class.java, *args)
}
