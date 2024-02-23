package com.emmanuel_rono.jibu.ui.theme.model

import androidx.room.Entity

@Entity(tableName = "detailTable")

data class Person(
val id: Int,
val firstName: String,
val lastName: String,
val age: Int
)

