package com.algokelvin.utils.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.algokelvin.utils.db.entity.Pocket
import com.algokelvin.utils.db.sql.PocketDao

@Database(entities = [Pocket::class], version = 1)
abstract class PocketDB : RoomDatabase() {
    abstract fun pocketDao() : PocketDao

    companion object {
        private val sLock = Any()
        private var INSTANCE: PocketDB? = null

        fun getInstance(context: Context): PocketDB {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        PocketDB::class.java, "Pocket.db"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE as PocketDB
            }
        }
    }
}
