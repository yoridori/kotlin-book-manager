/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.yoridori.book.manager.infrastructure.database.record

import java.time.LocalDateTime

data class Rental(
    var bookId: Long? = null,
    var userId: Long? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDeadline: LocalDateTime? = null
)