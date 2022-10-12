package com.yoridori.book.manager.domain.repository

import com.yoridori.book.manager.domain.model.Book
import com.yoridori.book.manager.domain.model.BookWithRental
import com.yoridori.book.manager.domain.model.Rental
import com.yoridori.book.manager.infrastructure.database.mapper.BookMapper
import com.yoridori.book.manager.infrastructure.database.mapper.custom.BookWithRentalMapper
import com.yoridori.book.manager.infrastructure.database.mapper.custom.select
import com.yoridori.book.manager.infrastructure.database.mapper.custom.selectByPrimaryKey
import com.yoridori.book.manager.infrastructure.database.mapper.insert
import com.yoridori.book.manager.infrastructure.database.record.BookRecord
import com.yoridori.book.manager.infrastructure.database.record.custom.BookWithRentalRecord
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl(
    private val bookWithRentalMapper: BookWithRentalMapper,
    private val bookMapper: BookMapper
) : BookRepository {
    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select().map { toModel(it) }
    }

    override fun findWithRental(id: Long): BookWithRental? {
        return bookWithRentalMapper.selectByPrimaryKey(id)?.let { toModel(it) }
    }

    override fun register(book: Book) {
        bookMapper.insert(toRecord(book))
    }

    private fun toModel(record: BookWithRentalRecord): BookWithRental {
        val book = Book(
            record.id!!,
            record.title!!,
            record.author!!,
            record.releaseDate!!
        )
        val rental = record.userId?.let {
            Rental(
                record.id!!,
                record.userId!!,
                record.rentalDatetime!!,
                record.returnDeadline!!
            )
        }
        return BookWithRental(book, rental)
    }

    private fun toRecord(model: Book): BookRecord {
        return BookRecord(model.id, model.title, model.author, model.releaseDate)
    }
}