package com.yoridori.book.manager.infrastructure.database.record.custom

import java.time.LocalDate
import java.time.LocalDateTime

data class BookWithRental(
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null,
    var userId: Long? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDatetime: LocalDateTime? = null,
)


