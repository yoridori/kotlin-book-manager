package com.yoridori.book.manager.infrastructure.database.mapper.custom

import com.yoridori.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.author
import com.yoridori.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.book
import com.yoridori.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.id
import com.yoridori.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.releaseDate
import com.yoridori.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.title
import com.yoridori.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rental
import com.yoridori.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rentalDatetime
import com.yoridori.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.returnDeadline
import com.yoridori.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.userId
import com.yoridori.book.manager.infrastructure.database.record.custom.BookWithRental
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.render.RenderingStrategies

private val columnList = listOf(
    id, title, author, releaseDate, userId, rentalDatetime, returnDeadline
)

fun BookWithRentalMapper.select(): List<BookWithRental> {
    val selectStatement =
        SqlBuilder
            .select(columnList)
            .from(book, "book")
            .leftJoin(rental, "rental")
            .on(book.id, SqlBuilder.equalTo(rental.bookId))
            .build().render(RenderingStrategies.MYBATIS3)
    return selectMany(selectStatement)
}