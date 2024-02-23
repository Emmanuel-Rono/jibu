package com.emmanuel_rono.jibu.ui.theme.model

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Query("SELECT *  FROM detailTable")
    fun readAllData(): Flow<List<Person>>
}
