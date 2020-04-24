package com.algokelvin.utils.db.sql

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.algokelvin.utils.db.entity.PocketEntity

@Dao
interface PocketDao {
    @Query("SELECT * FROM pocketentity WHERE type_pocket = :type AND date_pocket = :date") fun getAllPocket(type: String, date: String) : List<PocketEntity>
    @Insert fun insertPocket(pocketEntity: PocketEntity)
}