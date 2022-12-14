package com.yoridori.book.manager.domain.repository

import com.yoridori.book.manager.domain.model.Book
import com.yoridori.book.manager.domain.model.BookWithRental

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>

    fun findWithRental(id: Long): BookWithRental?

    fun register(book:Book)
}