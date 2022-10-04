/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.yoridori.book.manager.infrastructure.database.record

import com.yoridori.book.manager.domain.enum.RoleType

data class User(
    var id: Long? = null,
    var email: String? = null,
    var password: String? = null,
    var name: String? = null,
    var roleType: RoleType? = null
)