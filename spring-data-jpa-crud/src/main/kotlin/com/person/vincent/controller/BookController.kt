package com.person.vincent.controller

import com.person.vincent.model.Book
import com.person.vincent.service.BookJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    private lateinit var bookJapRepository: BookJpaRepository

    @GetMapping("/")
    fun index(): List<Book> = bookJapRepository.findAll()

    @GetMapping("/{id}")
    fun show(@PathVariable id: Int): Book = bookJapRepository.findOne(id)

    @PostMapping("/")
    fun create(@RequestBody book: Book): Book = bookJapRepository.save(book)

    @PutMapping("/")
    fun edit(@RequestBody book: Book): Book = bookJapRepository.saveAndFlush(book)

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable id: Int) = bookJapRepository.delete(id)
}