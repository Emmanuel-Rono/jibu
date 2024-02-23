package com.emmanuel_rono.jibu.ui.theme.model

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = true)
abstract class personDatabase : RoomDatabase() {
    abstract fun userDao():PersonDao
    companion object {
        // Singleton instance of the database
        @Volatile
        private var INSTANCE: personDatabase? = null

        fun getDatabase(context: Context): personDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: try {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        personDatabase::class.java,
                        "app_database"
                    ).createFromAsset("database/personDetails.db").build()
                    INSTANCE = instance
                    instance
                } catch (e: Exception) {
                    Log.e(TAG, "Error creating database from asset: ${e.message}")
                    throw e // Re-throw the exception to handle it at the caller side
                }
            }
        }
        }
        }
