package com.yoridori.book.manager.application.service

import com.yoridori.book.manager.domain.model.BookWithRental
import com.yoridori.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental()
    }
}